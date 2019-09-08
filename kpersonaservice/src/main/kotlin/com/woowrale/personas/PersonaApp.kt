package com.woowrale.personas

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

/**
 * The Class PersonasApp.
 */
@EnableDiscoveryClient
@SpringBootApplication
class PersonaApp

fun main(args: Array<String>) {
    SpringApplication.run(PersonaApp::class.java, *args)
}
