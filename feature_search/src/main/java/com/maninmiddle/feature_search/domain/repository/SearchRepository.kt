package com.maninmiddle.feature_search.domain.repository

import com.maninmiddle.core.util.ApiState
import com.maninmiddle.feature_search.domain.models.OfferModel

interface SearchRepository {
    suspend fun getOffers(): ApiState<List<OfferModel>>
}