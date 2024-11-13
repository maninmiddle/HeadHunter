package com.maninmiddle.feature_search.domain.repository

import com.maninmiddle.core.util.ApiState
import com.maninmiddle.feature_search.domain.models.OfferModel
import com.maninmiddle.feature_search.domain.models.VacanciesModel

interface SearchRepository {
    suspend fun getVacancies(): ApiState<List<VacanciesModel>>
    suspend fun getOffers(): ApiState<List<OfferModel>>
}