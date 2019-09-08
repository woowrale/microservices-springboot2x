package com.woowrale.eurekaservice

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@EnableEurekaServer
@SpringBootApplication
class EurekaserviceApp

fun main(args: Array<String>) {
	SpringApplication.run(EurekaserviceApp::class.java, *args)
}
