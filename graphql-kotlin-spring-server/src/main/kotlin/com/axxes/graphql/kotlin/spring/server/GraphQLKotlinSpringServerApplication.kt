package com.axxes.graphql.kotlin.spring.server

import com.axxes.graphql.core.CoreConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.core.io.ClassPathResource
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router

@SpringBootApplication
@Import(CoreConfiguration::class)
class GraphQLKotlinSpringServerApplication

fun main(args: Array<String>) {
    runApplication<GraphQLKotlinSpringServerApplication>(*args)
}

@Configuration
class Configuration {
    @Bean
    fun routesFun() = router {
        GET("/graphiql") {
            ServerResponse.ok().body(BodyInserters.fromResource(ClassPathResource("/graphiql.html")))
        }
    }
}
