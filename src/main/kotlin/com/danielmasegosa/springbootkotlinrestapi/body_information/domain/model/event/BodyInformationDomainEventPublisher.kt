package com.danielmasegosa.springbootkotlinrestapi.body_information.domain.model.event

interface BodyInformationDomainEventPublisher {
    fun publish(domainEvent: BodyInformationCreated)
}
