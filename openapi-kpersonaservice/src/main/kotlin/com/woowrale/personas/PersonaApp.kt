package com.woowrale.personas

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean


/**
 * The Class PersonasApp.
 */
@EnableDiscoveryClient
@SpringBootApplication
class PersonaApp{
    @Bean
    fun customOpenAPI(@Value("\${springdoc.version}") appVersion: String): OpenAPI {
        return OpenAPI()
                .components(Components().addSecuritySchemes("basicScheme",
                        SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(Info().title("SpringShop API").version(appVersion)
                        .license(License().name("Apache 2.0").url("http://springdoc.org")))
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(PersonaApp::class.java, *args)
}

