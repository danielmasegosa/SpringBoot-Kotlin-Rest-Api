package com.danielmasegosa.springbootkotlinrestapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories
class SpringBootKotlinRestApiApplication

fun main(args: Array<String>) {
    runApplication<SpringBootKotlinRestApiApplication>(*args)
}
