package com.maninmiddle.core.presentation.adapters

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maninmiddle.core.R
import com.maninmiddle.core.databinding.VacancyItemBinding
import com.maninmiddle.core.domain.models.VacanciesModel
import com.maninmiddle.core.util.formatDate


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