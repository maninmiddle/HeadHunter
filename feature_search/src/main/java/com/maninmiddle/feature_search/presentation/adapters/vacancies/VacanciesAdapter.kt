package com.maninmiddle.feature_search.presentation.adapters.vacancies

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.maninmiddle.feature_search.domain.models.VacanciesModel

class VacanciesAdapter() :
    AsyncListDifferDelegationAdapter<VacanciesModel>(VacanciesDiffCallback()) {


    init {
        delegatesManager.addDelegate(vacanciesItemDelegate())
    }
}