package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model

data class BodyInformation(
    val id: BodyInformationId,
    val measures: Measures,
    val weight: Weight,
    val images: List<Image>
)
