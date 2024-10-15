package com.maninmiddle.core.network.dto

import com.squareup.moshi.Json


data class VacanciesDto(

    @field:Json(name = "id") var id: String? = null,
    @field:Json(name = "lookingNumber") var lookingNumber: Int? = null,
    @field:Json(name = "title") var title: String? = null,
    @field:Json(name = "address") var addressDto: AddressDto? = AddressDto(),
    @field:Json(name = "company") var company: String? = null,
    @field:Json(name = "experience") var experienceDto: ExperienceDto? = ExperienceDto(),
    @field:Json(name = "publishedDate") var publishedDate: String? = null,
    @field:Json(name = "isFavorite") var isFavorite: Boolean? = null,
    @field:Json(name = "salary") var salaryDto: SalaryDto? = SalaryDto(),
    @field:Json(name = "schedules") var schedules: ArrayList<String> = arrayListOf(),
    @field:Json(name = "appliedNumber") var appliedNumber: Int? = null,
    @field:Json(name = "description") var description: String? = null,
    @field:Json(name = "responsibilities") var responsibilities: String? = null,
    @field:Json(name = "questions") var questions: ArrayList<String> = arrayListOf()

)