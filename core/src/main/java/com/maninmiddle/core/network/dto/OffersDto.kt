package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json

data class OffersDto(

    @field:Json(name = "id") var id: String? = null,
    @field:Json(name = "title") var title: String? = null,
    @field:Json(name = "link") var link: String? = null

)