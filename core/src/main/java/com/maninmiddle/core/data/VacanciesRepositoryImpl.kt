package com.maninmiddle.core.data

import com.maninmiddle.core.domain.VacanciesRepository
import com.maninmiddle.core.domain.models.VacanciesModel
import com.maninmiddle.core.network.ApiService
import com.maninmiddle.core.util.ApiState

class VacanciesRepositoryImpl(
    private val apiService: ApiService
): VacanciesRepository {
    override suspend fun getVacancies(): ApiState<List<VacanciesModel>> {
        return try {
            ApiState.Success(data = apiService.getVacancies().toListVacanciesModel())
        } catch (e: Exception) {
            e.printStackTrace()
            ApiState.Error(message = e.message ?: "An unknown message occurred")
        }
    }
}