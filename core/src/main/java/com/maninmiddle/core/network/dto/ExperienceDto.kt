package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json

data class ExperienceDto(
    @field:Json(name = "previewText") var previewText: String,
    @field:Json(name = "text") var text: String
)