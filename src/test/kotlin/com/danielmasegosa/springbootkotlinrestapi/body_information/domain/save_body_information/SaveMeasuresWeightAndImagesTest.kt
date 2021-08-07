package com.danielmasegosa.springbootkotlinrestapi.domain

import com.danielmasegosa.springbootkotlinrestapi.domain.model.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.times
import java.util.*

class SaveMeasuresWeightAndImagesTest {

    private val bodyInformationRepository: BodyInformationRepository = mock()

    private val subject = SaveBodyInformation(bodyInformationRepository)

    @Test
    internal fun `should invoke save method with the proper values`() {
        val bodyInformationCommand = SaveBodyInformationCommand(
            id = UUID.fromString("2fe63fe6-efb9-4529-baf1-67162a8ee5af"),
            armMeasure = 33.0,
            abdomenMeasure = 101.0,
            hipMeasure = 105.5,
            thighMeasure = 57.0,
            weight = 92.4,
            images = listOf("aImageUrl")
        )

        subject.execute(bodyInformationCommand)

        verify(bodyInformationRepository, times(1)).save(
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
}
