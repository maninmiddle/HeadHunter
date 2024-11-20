package com.example.feature_favourite.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feature_favourite.R
import com.example.feature_favourite.databinding.FragmentFavouriteBinding
import com.maninmiddle.core.presentation.adapters.VacanciesAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavouriteFragment : Fragment() {
    private val viewModel by viewModel<FavouriteViewModel>()
    private var _binding: FragmentFavouriteBinding? = null
    private val binding: FragmentFavouriteBinding
        get() = _binding ?: throw RuntimeException("FragmentFavouriteBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFavouritesRecyclerView()
    }

    private fun setupFavouritesRecyclerView() {
        val vacanciesAdapter = VacanciesAdapter()
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.state.collect { state ->
                    if (!state.isLoading) {
                        vacanciesAdapter.items = state.favourites
                        setupFavouritesSize(state.favourites?.size ?: 0)
                    }
                }
            }
        }
        binding.rvFavVacancies.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvFavVacancies.adapter = vacanciesAdapter
    }

    private fun setupFavouritesSize(total: Int) {
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