package com.maninmiddle.feature_search.presentation.vacancies

import com.maninmiddle.feature_search.domain.models.VacanciesModel

data class VacanciesUIState (
    val vacancies: List<VacanciesModel>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)