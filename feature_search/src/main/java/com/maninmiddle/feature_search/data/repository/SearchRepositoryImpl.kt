package com.maninmiddle.feature_search.data.repository

import com.maninmiddle.core.network.ApiService
import com.maninmiddle.core.util.ApiState
import com.maninmiddle.feature_search.data.mapper.toListOfferModel
import com.maninmiddle.feature_search.domain.models.OfferModel
import com.maninmiddle.feature_search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val apiService: ApiService
): SearchRepository {

    override suspend fun getOffers(): ApiState<List<OfferModel>> {
        return try {
            ApiState.Success(data = apiService.getOffers().toListOfferModel())
        } catch (e: Exception) {
            e.printStackTrace()
            ApiState.Error(message = e.message ?: "An unknown message occurred")
        }
    }
}