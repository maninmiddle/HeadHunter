package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json


data class VacanciesDto(

    @field:Json(name = "id") var id: String,
    @field:Json(name = "lookingNumber") var lookingNumber: Int,
    @field:Json(name = "title") var title: String,
    @field:Json(name = "address") var addressDto: AddressDto,
    @field:Json(name = "company") var company: String,
    @field:Json(name = "experience") var experienceDto: ExperienceDto,
    @field:Json(name = "publishedDate") var publishedDate: String,
    @field:Json(name = "isFavorite") var isFavorite: Boolean,
    @field:Json(name = "salary") var salaryDto: SalaryDto,
    @field:Json(name = "schedules") var schedules: List<String>,
    @field:Json(name = "appliedNumber") var appliedNumber: Int,
    @field:Json(name = "description") var description: String,
    @field:Json(name = "responsibilities") var responsibilities: String,
    @field:Json(name = "questions") var questions: List<String>

)