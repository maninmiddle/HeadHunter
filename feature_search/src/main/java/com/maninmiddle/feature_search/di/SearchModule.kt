package com.maninmiddle.feature_search.di

import com.maninmiddle.feature_search.data.repository.SearchRepositoryImpl
import com.maninmiddle.feature_search.domain.repository.SearchRepository
import com.maninmiddle.feature_search.presentation.search.SearchViewModel
import com.maninmiddle.feature_search.presentation.vacancies.VacanciesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val searchModule = module {
    single<SearchRepository> { SearchRepositoryImpl(get()) }
    viewModel { SearchViewModel(get()) }

    viewModel { VacanciesViewModel(get()) }
}