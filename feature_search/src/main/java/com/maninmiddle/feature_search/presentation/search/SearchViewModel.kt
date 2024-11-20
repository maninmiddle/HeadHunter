package com.maninmiddle.feature_search.presentation.search

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maninmiddle.core.domain.VacanciesRepository
import com.maninmiddle.core.util.ApiState
import com.maninmiddle.feature_search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchRepository: SearchRepository,
    private val vacanciesRepository: VacanciesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(SearchUIState())

    val state: StateFlow<SearchUIState>
        get() = _state

    init {
        loadOffers()
        loadVacancies()
    }

    private fun loadVacancies() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoading = true,
                error = null,
                vacancies = null
            )
            when (val result = vacanciesRepository.getVacancies()) {
                is ApiState.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        vacancies = result.data,
                        error = null
                    )
                }

                is ApiState.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        vacancies = null,
                        error = result.message
                    )
                }

                else -> Log.e("[API]", "Api call error")
            }
        }
    }

    private fun loadOffers() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                isLoading = true,
                offers = null,
                error = null
            )
            when (val result = searchRepository.getOffers()) {
                is ApiState.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        offers = result.data,
                        error = null
                    )
                }

                is ApiState.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        error = result.message,
                        offers = null
                    )
                }

                else -> Log.e("[API]", "Api call error")
            }
        }
    }
}