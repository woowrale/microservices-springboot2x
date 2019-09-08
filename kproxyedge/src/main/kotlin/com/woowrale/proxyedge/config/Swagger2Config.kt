package com.woowrale.proxyedge.config

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
class Swagger2Config {

    @Bean
    fun swaggerConfig(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.woowrale.proxyedge"))
                .paths(paths())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Documentation Api")
                .description("Description of the api methods")
                .version("1.0")
                .contact(contact())
                .termsOfServiceUrl("Terms of service")
                .build()
    }

    private fun contact(): Contact {
        return Contact("Woowrale", "http://woowrale.com", "woowrale@gmail.com")
    }

    private fun paths(): Predicate<String> {
        return Predicates.not(PathSelectors.regex("/error.*"))
    }
}