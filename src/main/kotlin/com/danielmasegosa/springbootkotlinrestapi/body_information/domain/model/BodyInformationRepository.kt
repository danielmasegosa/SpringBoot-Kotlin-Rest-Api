package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model

interface BodyInformationRepository {
    fun save(bodyInformation: BodyInformation) {
        throw UnsupportedOperationException("Not implemented!")
    }

}
