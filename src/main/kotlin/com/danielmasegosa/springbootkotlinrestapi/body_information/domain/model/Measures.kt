package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model

data class Measures(
    val armMeasure: ArmMeasure,
    val abdomenMeasure: AbdomenMeasure,
    val hipMeasure: HipMeasure,
    val thighMeasure: ThighMeasure
)
