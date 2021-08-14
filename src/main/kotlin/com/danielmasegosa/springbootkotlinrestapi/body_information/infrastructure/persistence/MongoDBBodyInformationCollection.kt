package com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence

import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.BodyInformation
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.persistence.BodyInformationRepository
import com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence.model.BodyInformationEntity
import org.springframework.stereotype.Component

@Component
class MongoDBBodyInformationCollection(val mongoRepository: MongoDBBodyInformationRepository) :
    BodyInformationRepository {

    override fun save(bodyInformation: BodyInformation) {
        mongoRepository.save(BodyInformationEntity(
            _id = bodyInformation.id.value,
            armMeasure = bodyInformation.measures.armMeasure.value,
            hipMeasure = bodyInformation.measures.hipMeasure.value,
            thighMeasure = bodyInformation.measures.thighMeasure.value,
            abdomenMeasure = bodyInformation.measures.abdomenMeasure.value,
            weight = bodyInformation.weight.value,
            images = bodyInformation.images.map { it.url.value }
        ))
    }
}
