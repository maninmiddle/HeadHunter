package com.maninmiddle.core.domain.models


data class VacanciesModel(

    var id: String,
    var lookingNumber: Int,
    var title: String,
    var addressModel: AddressModel,
    var company: String,
    var experienceModel: ExperienceModel,
    var publishedDate: String,
    var isFavorite: Boolean,
    var salaryModel: SalaryModel,
    var schedules: List<String>,
    var appliedNumber: Int,
    var description: String?,
    var responsibilities: String,
    var questions: List<String>

)