package com.maninmiddle.feature_search.presentation.adapters.offer

import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import com.maninmiddle.feature_search.domain.models.OfferModel

class OfferAdapter: AsyncListDifferDelegationAdapter<OfferModel>(OfferAdapterDiffCallback()) {
    init {
        delegatesManager.addDelegate(offerItemDelegate())
    }
}