package com.maninmiddle.core.di

import com.maninmiddle.core.network.ApiService
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://6734a278a042ab85d11b050a.mockapi.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(ApiService::class.java)
    }
}