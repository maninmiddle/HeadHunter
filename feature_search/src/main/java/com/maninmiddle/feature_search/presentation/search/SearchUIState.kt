package com.maninmiddle.feature_search.presentation.search

import com.maninmiddle.core.domain.models.VacanciesModel
import com.maninmiddle.feature_search.domain.models.OfferModel

data class SearchUIState (
    val offers: List<OfferModel>? = emptyList(),
    val vacancies: List<VacanciesModel>? = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)