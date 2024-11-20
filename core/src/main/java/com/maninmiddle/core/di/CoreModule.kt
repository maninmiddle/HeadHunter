package com.maninmiddle.core.di

import com.maninmiddle.core.data.VacanciesRepositoryImpl
import com.maninmiddle.core.domain.VacanciesRepository
import org.koin.dsl.module

val coreModule = module {
    single<VacanciesRepository> { VacanciesRepositoryImpl(get()) }
}