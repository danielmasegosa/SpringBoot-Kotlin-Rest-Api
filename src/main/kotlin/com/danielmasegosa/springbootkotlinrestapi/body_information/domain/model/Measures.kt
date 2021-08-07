package com.danielmasegosa.springbootkotlinrestapi.domain.model

data class Measures(
    private val armMeasure: ArmMeasure,
    private val abdomenMeasure: AbdomenMeasure,
    private val hipMeasure: HipMeasure,
    private val thighMeasure: ThighMeasure
)
