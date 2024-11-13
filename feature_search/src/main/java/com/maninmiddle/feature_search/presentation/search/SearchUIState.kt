package com.maninmiddle.feature_search.presentation.search

import com.maninmiddle.feature_search.domain.models.OfferModel
import com.maninmiddle.feature_search.domain.models.VacanciesModel

data class SearchUIState (
    val offers: List<OfferModel>? = emptyList(),
    val vacancies: List<VacanciesModel>? = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)