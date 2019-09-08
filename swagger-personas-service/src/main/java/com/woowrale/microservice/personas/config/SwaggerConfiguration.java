package com.woowrale.microservice.personas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * The Class SwaggerConfiguration.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	/**
	 * Swagger config.
	 *
	 * @return the docket
	 */
	@Bean
    public Docket swaggerConfig() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .select()                                  
                .apis(RequestHandlerSelectors.basePackage("com.woowrale.microservice.personas"))              
                .paths(paths())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo());
          }
	
	/**
	 * Api info.
	 *
	 * @return the api info
	 */
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("Documentation Api")
				.description("Description of the api methods")
				.version("1.0")
				.contact(contact())
				.termsOfServiceUrl("Terms of service")				
				.build();
		return apiInfo;
	}

	/**
	 * Contact.
	 *
	 * @return the contact
	 */
	private Contact contact() {
		Contact c = new Contact("Woowrale", "http://woowrale.com", "woowrale@gmail.com");
		return c;
	}
	
	/**
	 * Paths.
	 *
	 * @return the predicate
	 */
	private Predicate<String> paths() {
        return Predicates.not(PathSelectors.regex("/error.*"));
    }
}