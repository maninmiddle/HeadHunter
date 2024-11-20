package com.example.feature_favourite.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maninmiddle.core.domain.VacanciesRepository
import com.maninmiddle.core.util.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavouriteViewModel(
    private val repository: VacanciesRepository
): ViewModel() {
    private val _state = MutableStateFlow(FavouritesUIState())
    val state: StateFlow<FavouritesUIState>
        get() = _state

    init {
        loadVacancies()
    }

    private fun loadVacancies() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                favourites = null,
                isLoading = true,
                error = null
            )

            when (val result = repository.getVacancies()) {
                is ApiState.Success -> {
                    _state.value = state.value.copy(
                        favourites = result.data?.filter { it.isFavorite },
                        isLoading = false,
                        error = null
                    )
                }

                is ApiState.Error -> {
                    _state.value = state.value.copy(
                        favourites = null,
                        error = result.message,
                        isLoading = false
                    )
                }

                else -> Log.e("[API]", "Api call error")
            }
        }
    }
}