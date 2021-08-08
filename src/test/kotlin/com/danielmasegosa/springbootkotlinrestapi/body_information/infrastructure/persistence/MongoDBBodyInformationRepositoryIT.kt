package com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence

import com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.*
import com.danielmasegosa.springbootkotlinrestapi.body_information.infrastructure.persistence.model.BodyInformationEntity
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.kotlin.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.context.annotation.Import
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import java.util.*

@Testcontainers
@DataMongoTest
@Import(MongoDBBodyInformationRepositoryIT.Config::class)
class MongoDBBodyInformationRepositoryIT {
    
    @SpyBean
    private lateinit var mongoDBRepository: MongoDBBodyInformationRepository

    @Autowired
    private lateinit var subject: BodyInformationRepository

    companion object {
        @Container
        val mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:4.4.2").apply { start() }

        @JvmStatic
        @DynamicPropertySource
        fun setProperties(registry: DynamicPropertyRegistry) =
            registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl)
    }


    @Test
    internal fun `should invoke to the save method with the proper values`() {
        val bodyInformation = BodyInformation(
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

        subject.save(
            bodyInformation
        )

        verify(mongoDBRepository).save(
            BodyInformationEntity(
                _id = UUID.fromString("2fe63fe6-efb9-4529-baf1-67162a8ee5af"),
                armMeasure = 33.0,
                abdomenMeasure = 101.0,
                hipMeasure = 105.5,
                thighMeasure = 57.0,
                weight = 92.4,
                images = listOf("aImageUrl")
            )
        )
    }

    @Test
    internal fun `should store the body information`() {
        val identifier = UUID.fromString("2fe63fe6-efb9-4529-baf1-67162a8ee5af")
        val bodyInformation = BodyInformation(
            id = BodyInformationId(value = identifier),
            measures = Measures(
                armMeasure = ArmMeasure(value = 33.0),
                abdomenMeasure = AbdomenMeasure(101.0),
                hipMeasure = HipMeasure(105.5),
                thighMeasure = ThighMeasure(57.0)
            ),
            weight = Weight(value = 92.4),
            images = listOf(Image(url = Url(value = "aImageUrl")))
        )

        subject.save(
            bodyInformation
        )

        val findById = mongoDBRepository.findById(identifier)
        assertTrue(findById.isPresent)
        assertEquals(
            BodyInformationEntity(
                _id = UUID.fromString("2fe63fe6-efb9-4529-baf1-67162a8ee5af"),
                armMeasure = 33.0,
                hipMeasure = 105.5,
                thighMeasure = 57.0,
                abdomenMeasure = 101.0,
                weight = 92.4,
                images = listOf("aImageUrl")
            ), findById.get()
        )
    }

    @Import(MongoDBBodyInformationCollection::class)
    class Config
}
