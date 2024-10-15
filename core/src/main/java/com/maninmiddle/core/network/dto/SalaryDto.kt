package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json

data class SalaryDto(

    @field:Json(name = "full") var full: String? = null

)