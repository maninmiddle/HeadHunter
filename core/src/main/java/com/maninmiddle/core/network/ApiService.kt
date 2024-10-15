package com.maninmiddle.core.network

import com.maninmiddle.core.network.dto.OffersDto
import com.maninmiddle.core.network.dto.VacanciesDto
import retrofit2.http.GET

interface ApiService {
    @GET("offers")
    suspend fun getOffers(): List<OffersDto>

    @GET("vacancies")
    suspend fun getVacancies(): List<VacanciesDto>

}