package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model

data class BodyInformation(
    private val id: BodyInformationId,
    private val measures: Measures,
    private val weight: Weight,
    private val images: List<Image>
)
