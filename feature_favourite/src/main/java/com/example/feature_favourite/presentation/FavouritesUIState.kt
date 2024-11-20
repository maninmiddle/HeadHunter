package com.example.feature_favourite.presentation

import com.maninmiddle.core.domain.models.VacanciesModel

data class FavouritesUIState (
    val favourites: List<VacanciesModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
