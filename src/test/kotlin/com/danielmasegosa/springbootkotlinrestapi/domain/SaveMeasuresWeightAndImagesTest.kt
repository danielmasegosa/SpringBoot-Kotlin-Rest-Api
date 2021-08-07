package com.danielmasegosa.springbootkotlinrestapi.domain

import com.danielmasegosa.springbootkotlinrestapi.domain.model.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito.verify
import org.mockito.kotlin.mock
import org.mockito.kotlin.times

class SaveMeasuresWeightAndImagesTest {

    private val bodyInformationRepository: BodyInformationRepository = mock()

    private val subject = SaveMeasuresWeightAndImages()

    @Test
    internal fun `should invoke save method with the proper values`() {
        val bodyInformation = BodyInformation(
                measures = Measures(
                        armMeasure = ArmMeasure(value = 33.0),
                        abdomenMeasure = AbdomenMeasure(101.0),
                        hipMeasure = HipMeasure(105.5),
                        thighMeasure = ThighMeasure(57.0)
                ),
                weight = Weight(value = 92.4),
                listOf = listOf(Image(url = Url(value = "aImageUrl")))
        )

        subject.save(bodyInformation)

        verify(bodyInformationRepository, times(1)).save(bodyInformation)
    }
}
