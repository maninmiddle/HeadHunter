package com.maninmiddle.core.presentation.adapters

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.maninmiddle.core.domain.models.VacanciesModel

class VacanciesAdapter() :
    AsyncListDifferDelegationAdapter<VacanciesModel>(VacanciesDiffCallback()) {


    init {
        delegatesManager.addDelegate(vacanciesItemDelegate())
    }
}