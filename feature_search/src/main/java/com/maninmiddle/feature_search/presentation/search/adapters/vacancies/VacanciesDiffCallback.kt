package com.maninmiddle.feature_search.presentation.search.adapters.vacancies

import androidx.recyclerview.widget.DiffUtil
import com.maninmiddle.feature_search.domain.models.VacanciesModel

class VacanciesDiffCallback: DiffUtil.ItemCallback<VacanciesModel>() {
    override fun areItemsTheSame(oldItem: VacanciesModel, newItem: VacanciesModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VacanciesModel, newItem: VacanciesModel): Boolean {
        return oldItem == newItem
    }
}