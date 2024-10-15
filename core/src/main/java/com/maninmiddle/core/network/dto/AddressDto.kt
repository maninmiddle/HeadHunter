package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json

data class AddressDto(
    @field:Json(name = "town") var town: String? = null,
    @field:Json(name = "street") var street: String? = null,
    @field:Json(name = "house") var house: String? = null
)