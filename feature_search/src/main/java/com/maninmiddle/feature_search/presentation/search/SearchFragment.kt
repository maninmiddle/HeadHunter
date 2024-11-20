package com.maninmiddle.feature_search.presentation.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maninmiddle.core.util.MainActivityFragmentContract
import com.maninmiddle.feature_search.R
import com.maninmiddle.feature_search.databinding.FragmentSearchBinding
import com.maninmiddle.feature_search.presentation.adapters.offer.OfferAdapter
import com.maninmiddle.feature_search.presentation.adapters.vacancies.VacanciesAdapter
import com.maninmiddle.feature_search.presentation.vacancies.VacanciesFragment
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val viewModel by viewModel<SearchViewModel>()
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException("FragmentSearchBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupOffersRecyclerView()
        setupVacanciesRecyclerView()

        binding.moreButton.setOnClickListener {
            val mainActivity = requireActivity() as MainActivityFragmentContract
            val vacanciesFragment = VacanciesFragment()
            mainActivity.addFragment(vacanciesFragment)
        }


    }

    private fun setupVacanciesRecyclerView() {
        val vacanciesAdapter = VacanciesAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    if (!state.isLoading) {
                        vacanciesAdapter.items = state.vacancies?.take(2)
                        setupVacanciesSize(state.vacancies?.size ?: 0)
                    }
                }
            }
        }
        binding.rvVacancies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvVacancies.adapter = vacanciesAdapter
    }

    private fun setupVacanciesSize(total: Int) {
        val rightCountedVacanciesText = when {
            total % 10 == 1 && total % 100 == 11 -> "$total вакансия"
            total % 10 in 2..4 && (total % 100 !in 12..24) -> "$total вакансии"
            else -> "$total вакансий"
        }
        binding.moreButton.text = getString(R.string.stringMoreVacancies, rightCountedVacanciesText)
    }

    private fun setupOffersRecyclerView() {
        val offerAdapter = OfferAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    if (!state.isLoading) {
                        offerAdapter.items = state.offers
                    }
                }
            }
        }
        binding.rvOffers.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.rvOffers.adapter = offerAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}