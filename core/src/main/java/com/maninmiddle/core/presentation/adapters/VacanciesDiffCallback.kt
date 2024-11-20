package com.maninmiddle.core.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.maninmiddle.core.domain.models.VacanciesModel

class VacanciesDiffCallback: DiffUtil.ItemCallback<VacanciesModel>() {
    override fun areItemsTheSame(oldItem: VacanciesModel, newItem: VacanciesModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: VacanciesModel, newItem: VacanciesModel): Boolean {
        return oldItem == newItem
    }
}