package com.maninmiddle.feature_search.presentation.vacancies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maninmiddle.core.presentation.adapters.VacanciesAdapter
import com.maninmiddle.feature_search.R
import com.maninmiddle.feature_search.databinding.FragmentVacanciesBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class VacanciesFragment : Fragment() {
    private val viewModel by viewModel<VacanciesViewModel>()
    private var _binding: FragmentVacanciesBinding? = null
    private val binding:  FragmentVacanciesBinding
        get() = _binding ?: throw RuntimeException("FragmentVacanciesBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVacanciesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupVacanciesRecyclerView()

        binding.backIcon.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

    }

    private fun setupVacanciesRecyclerView() {
        val vacanciesAdapter = VacanciesAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    vacanciesAdapter.items = state.vacancies
                    setupVacanciesCount(state.vacancies?.size ?: 0)
                }
            }
        }
        binding.rvAllVacancies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvAllVacancies.adapter = vacanciesAdapter
    }

    private fun setupVacanciesCount(total: Int) {
        val rightCountedVacanciesText = when {
            total % 10 == 1 && total % 100 == 1 -> "$total вакансия"
            total % 10 in 2..4 && (total % 100 !in 12..24) -> "$total вакансии"
            else -> "$total вакансий"
        }
        binding.tvVacanciesCount.text = getString(R.string.stringVacanciesCount, rightCountedVacanciesText)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}