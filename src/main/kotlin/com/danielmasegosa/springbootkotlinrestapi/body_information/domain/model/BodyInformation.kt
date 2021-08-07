package com.danielmasegosa.springbootkotlinrestapi.domain.model

data class BodyInformation(
    private val id: BodyInformationId,
    private val measures: Measures,
    private val weight: Weight,
    private val images: List<Image>
)
