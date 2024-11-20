package com.maninmiddle.feature_search.presentation.vacancies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.maninmiddle.feature_search.R
import com.maninmiddle.feature_search.databinding.FragmentVacanciesBinding
import com.maninmiddle.feature_search.presentation.adapters.vacancies.VacanciesAdapter
import kotlinx.coroutines.flow.collect
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

    }

    private fun setupVacanciesRecyclerView() {
        val vacanciesAdapter = VacanciesAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    vacanciesAdapter.items = state.vacancies

                }
            }
        }
        binding.rvAllVacancies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvAllVacancies.adapter = vacanciesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}