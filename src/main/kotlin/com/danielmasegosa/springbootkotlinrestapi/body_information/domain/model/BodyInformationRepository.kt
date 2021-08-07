package com.danielmasegosa.springbootkotlinrestapi.domain.model

interface BodyInformationRepository {
    fun save(bodyInformation: BodyInformation) {
        throw UnsupportedOperationException("Not implemented!")
    }

}
