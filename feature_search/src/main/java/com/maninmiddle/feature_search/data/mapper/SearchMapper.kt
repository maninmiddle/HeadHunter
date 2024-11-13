package com.maninmiddle.feature_search.data.mapper

import com.maninmiddle.core.network.dto.AddressDto
import com.maninmiddle.core.network.dto.ExperienceDto
import com.maninmiddle.core.network.dto.OffersDto
import com.maninmiddle.core.network.dto.SalaryDto
import com.maninmiddle.core.network.dto.VacanciesDto
import com.maninmiddle.feature_search.domain.models.AddressModel
import com.maninmiddle.feature_search.domain.models.ExperienceModel
import com.maninmiddle.feature_search.domain.models.OfferModel
import com.maninmiddle.feature_search.domain.models.SalaryModel
import com.maninmiddle.feature_search.domain.models.VacanciesModel

fun List<OffersDto>.toListOfferModel(): List<OfferModel> {
    return this.map { offersDto ->
        OfferModel(
            id = offersDto.id ,
            title = offersDto.title,
            link = offersDto.link
        )
    }
}

fun List<VacanciesDto>.toListVacanciesModel(): List<VacanciesModel> {
    return this.map { vacanciesDto ->
        VacanciesModel(
            id = vacanciesDto.id,
            lookingNumber = vacanciesDto.lookingNumber,
            title = vacanciesDto.title,
            addressModel = vacanciesDto.addressDto.toAddressModel(),
            company = vacanciesDto.company,
            experienceModel = vacanciesDto.experienceDto.toExperienceModel(),
            publishedDate = vacanciesDto.publishedDate,
            isFavorite = vacanciesDto.isFavorite,
            salaryModel = vacanciesDto.salaryDto.toSalaryModel(),
            schedules = vacanciesDto.schedules,
            appliedNumber = vacanciesDto.appliedNumber,
            description = vacanciesDto.description ,
            responsibilities = vacanciesDto.responsibilities,
            questions = vacanciesDto.questions
        )
    }
}

fun SalaryDto.toSalaryModel(): SalaryModel {
    return SalaryModel(
        full = full
    )
}

fun ExperienceDto.toExperienceModel(): ExperienceModel {
    return ExperienceModel(
        previewText = previewText,
        text = text
    )
}

fun AddressDto.toAddressModel(): AddressModel {
    return AddressModel(
        town = town,
        street = street,
        house = house
    )
}