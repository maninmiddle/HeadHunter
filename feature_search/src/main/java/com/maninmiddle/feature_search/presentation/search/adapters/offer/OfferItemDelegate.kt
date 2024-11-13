package com.maninmiddle.feature_search.presentation.search.adapters.offer

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.maninmiddle.feature_search.databinding.OfferItemBinding
import com.maninmiddle.feature_search.domain.models.OfferModel

fun offerItemDelegate() = adapterDelegateViewBinding<OfferModel, OfferModel, OfferItemBinding>(
    viewBinding = { inflater, parent -> OfferItemBinding.inflate(inflater, parent, false) }
) {
    bind {
        binding.tvTitle.text = item.title
    }
}