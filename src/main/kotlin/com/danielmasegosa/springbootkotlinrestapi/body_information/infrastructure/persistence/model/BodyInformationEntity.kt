package com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(value = "body_information")
data class BodyInformationEntity(
    @Id
    val _id: UUID,
    val armMeasure: Double,
    val abdomenMeasure: Double,
    val hipMeasure: Double,
    val thighMeasure: Double,
    val weight: Double,
    val images: List<String>
)
