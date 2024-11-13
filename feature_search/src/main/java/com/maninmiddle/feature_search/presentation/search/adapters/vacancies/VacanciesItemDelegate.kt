package com.maninmiddle.feature_search.presentation.search.adapters.vacancies

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maninmiddle.feature_search.R
import com.maninmiddle.feature_search.databinding.VacancyItemBinding
import com.maninmiddle.feature_search.domain.models.VacanciesModel
import com.maninmiddle.feature_search.util.formatDate

fun vacanciesItemDelegate() =
    adapterDelegateViewBinding<VacanciesModel, VacanciesModel, VacancyItemBinding>(
        viewBinding = { inflater, parent -> VacancyItemBinding.inflate(inflater, parent, false) }
    ) {
        bind {
            binding.tvVacancyTitle.text = item.title
            binding.tvNowLooking.text =
                getString(R.string.stringNowLooking, item.lookingNumber)
            binding.tvExperience.text = item.experienceModel.previewText
            binding.tvVacancyCompanyName.text = item.company
            binding.tvVacancyCountry.text = item.addressModel.town
            binding.tvPublicationDate.text =
                getString(R.string.stringPublicationDate, formatDate(item.publishedDate).toString())
        }
    }