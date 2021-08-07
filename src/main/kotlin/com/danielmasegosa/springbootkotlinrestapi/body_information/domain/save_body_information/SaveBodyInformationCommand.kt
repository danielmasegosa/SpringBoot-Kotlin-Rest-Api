package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.save_body_information

import java.util.*

data class SaveBodyInformationCommand(
    val id: UUID,
    val armMeasure: Double,
    val abdomenMeasure: Double,
    val hipMeasure: Double,
    val thighMeasure: Double,
    val weight: Double,
    val images: List<String>
)
