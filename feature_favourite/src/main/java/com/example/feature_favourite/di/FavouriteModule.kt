package com.example.feature_favourite.di

import com.example.feature_favourite.presentation.FavouriteViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favouriteModule = module {
    viewModel { FavouriteViewModel(get()) }
}