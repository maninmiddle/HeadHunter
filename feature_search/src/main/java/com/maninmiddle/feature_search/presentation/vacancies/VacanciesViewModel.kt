package com.maninmiddle.feature_search.presentation.vacancies

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maninmiddle.core.domain.VacanciesRepository
import com.maninmiddle.core.util.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VacanciesViewModel(
    private val repository: VacanciesRepository
) : ViewModel() {
    private val _state = MutableStateFlow(VacanciesUIState())
    val state: StateFlow<VacanciesUIState>
        get() = _state

    init {
        loadVacancies()
    }

    private fun loadVacancies() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                vacancies = null,
                isLoading = true,
                error = null
            )

            when (val result = repository.getVacancies()) {
                is ApiState.Success -> {
                    _state.value = state.value.copy(
                        vacancies = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is ApiState.Error -> {
                    _state.value = state.value.copy(
                        vacancies = null,
                        error = result.message,
                        isLoading = false
                    )
                }

                else -> Log.e("[API]", "Api call error")
            }
        }
    }
}