package com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence

import com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence.model.BodyInformationEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MongoDBBodyInformationRepository : MongoRepository<BodyInformationEntity, UUID> {
}
