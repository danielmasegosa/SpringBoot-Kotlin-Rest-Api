package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.save_body_information

import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.*
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.event.BodyInformationCreated
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.event.BodyInformationDomainEventPublisher
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.persistence.BodyInformationRepository

class SaveBodyInformation(
    private val bodyInformationRepository: BodyInformationRepository,
    private val bodyInformationCreatedEventPublisher: BodyInformationDomainEventPublisher
) {

    fun execute(bodyInformationCommand: SaveBodyInformationCommand) {
        val id = BodyInformationId(value = bodyInformationCommand.id)
        val bodyInformation = BodyInformation(
            id,
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
        bodyInformationCreatedEventPublisher.publish(BodyInformationCreated(id))
    }

}
