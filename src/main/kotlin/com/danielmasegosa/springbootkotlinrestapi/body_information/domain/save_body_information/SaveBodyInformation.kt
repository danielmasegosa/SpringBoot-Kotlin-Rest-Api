package com.danielmasegosa.springbootkotlinrestapi.domain

import com.danielmasegosa.springbootkotlinrestapi.domain.model.*

class SaveBodyInformation(private val bodyInformationRepository: BodyInformationRepository) {

    fun execute(bodyInformationCommand: SaveBodyInformationCommand) {
        val bodyInformation = BodyInformation(
            id = BodyInformationId(value = bodyInformationCommand.id),
            measures = Measures(
                armMeasure = ArmMeasure(value = bodyInformationCommand.armMeasure),
                abdomenMeasure = AbdomenMeasure(value = bodyInformationCommand.abdomenMeasure),
                hipMeasure = HipMeasure(value = bodyInformationCommand.hipMeasure),
                thighMeasure = ThighMeasure(value = bodyInformationCommand.thighMeasure)
            ),
            weight = Weight(value = bodyInformationCommand.weight),
            images = bodyInformationCommand.images.map { Image(url = Url(value = it)) }
        )

        bodyInformationRepository.save(
            bodyInformation
        )
    }

}
