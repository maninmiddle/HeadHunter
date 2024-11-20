package com.maninmiddle.core.domain

import com.maninmiddle.core.domain.models.VacanciesModel
import com.maninmiddle.core.util.ApiState

interface VacanciesRepository {
    suspend fun getVacancies(): ApiState<List<VacanciesModel>>
}