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
import com.maninmiddle.feature_search.databinding.FragmentSearchBinding
import com.maninmiddle.feature_search.presentation.search.adapters.offer.OfferAdapter
import com.maninmiddle.feature_search.presentation.search.adapters.vacancies.VacanciesAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    val viewModel by viewModel<SearchViewModel>()
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

    }

    private fun setupVacanciesRecyclerView() {
        val vacanciesAdapter = VacanciesAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {state ->
                    if (!state.isLoading) {
                        vacanciesAdapter.items = state.vacancies
                    }
                }
            }
        }
        binding.rvVacancies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvVacancies.adapter = vacanciesAdapter
    }

    private fun setupOffersRecyclerView() {
        val offerAdapter = OfferAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect {state ->
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