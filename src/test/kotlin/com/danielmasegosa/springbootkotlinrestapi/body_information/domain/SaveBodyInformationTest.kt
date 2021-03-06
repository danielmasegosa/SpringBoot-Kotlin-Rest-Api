package com.danielmasegosa.springbootkotlinrestapi.body_information.domain

import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.*
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.event.BodyInformationCreated
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.event.BodyInformationDomainEventPublisher
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.persistence.BodyInformationRepository
import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.save_body_information.SaveBodyInformation
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import java.util.*

class SaveBodyInformationTest {

    private val bodyInformationRepository = mock<BodyInformationRepository>()

    private val bodyInformationCreatedEventPublisher = mock<BodyInformationDomainEventPublisher>()

    private val subject = SaveBodyInformation(bodyInformationRepository, bodyInformationCreatedEventPublisher)

    @Test
    internal fun `should invoke save method with the proper values`() {
        val bodyInformationCommand = BodyInformationCommandMother.aBodyInformation()

        subject.execute(bodyInformationCommand)

        verify(bodyInformationRepository).save(
            BodyInformation(
                id = BodyInformationId(value = UUID.fromString("2fe63fe6-efb9-4529-baf1-67162a8ee5af")),
                measures = Measures(
                    armMeasure = ArmMeasure(value = 33.0),
                    abdomenMeasure = AbdomenMeasure(101.0),
                    hipMeasure = HipMeasure(105.5),
                    thighMeasure = ThighMeasure(57.0)
                ),
                weight = Weight(value = 92.4),
                images = listOf(Image(url = Url(value = "aImageUrl")))
            )
        )
    }

    @Test
    internal fun `should publish a domain event with the proper values`() {
        val bodyInformationCommand = BodyInformationCommandMother.aBodyInformation()

        subject.execute(bodyInformationCommand)

        verify(bodyInformationCreatedEventPublisher).publish(
            BodyInformationCreated(
                bodyInformationId = BodyInformationId(
                    UUID.fromString
                        ("2fe63fe6-efb9-4529-baf1-67162a8ee5af")
                ),
                measures = Measures(
                    armMeasure = ArmMeasure(value = 33.0),
                    abdomenMeasure = AbdomenMeasure(101.0),
                    hipMeasure = HipMeasure(105.5),
                    thighMeasure = ThighMeasure(57.0)
                ),
                weight = Weight(value = 92.4),
                images = listOf(Image(url = Url(value = "aImageUrl")))
            )
        )
    }
}
