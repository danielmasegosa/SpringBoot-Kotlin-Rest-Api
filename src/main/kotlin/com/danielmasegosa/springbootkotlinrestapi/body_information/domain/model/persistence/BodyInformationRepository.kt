package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.persistence

import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.BodyInformation

interface BodyInformationRepository {
    fun save(bodyInformation: BodyInformation)
}
