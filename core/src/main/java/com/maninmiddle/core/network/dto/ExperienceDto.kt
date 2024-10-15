package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json

data class ExperienceDto(

    @field:Json(name = "previewText") var previewText: String? = null,
    @field:Json(name = "text") var text: String? = null

)