package com.maninmiddle.feature_search.presentation.adapters.offer

import androidx.recyclerview.widget.DiffUtil
import com.maninmiddle.feature_search.domain.models.OfferModel

class OfferAdapterDiffCallback: DiffUtil.ItemCallback<OfferModel>() {
    override fun areItemsTheSame(oldItem: OfferModel, newItem: OfferModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: OfferModel, newItem: OfferModel): Boolean {
        return oldItem == newItem
    }
}