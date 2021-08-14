package com.danielmasegosa.springbootkotlinrestapi.body_information.domain

import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.save_body_information.SaveBodyInformationCommand
import java.util.*

class BodyInformationCommandMother {

    companion object {
        fun aBodyInformation(
            id: UUID = UUID.fromString("2fe63fe6-efb9-4529-baf1-67162a8ee5af"),
            armMeasure: Double = 33.0,
            abdomenMeasure: Double = 101.0,
            hipMeasure: Double = 105.5,
            thighMeasure: Double = 57.0,
            weight: Double = 92.4,
            images: List<String> = listOf("aImageUrl")
        ): SaveBodyInformationCommand = SaveBodyInformationCommand(
            id,
            armMeasure,
            abdomenMeasure,
            hipMeasure,
            thighMeasure,
            weight,
            images
        )
    }
}
