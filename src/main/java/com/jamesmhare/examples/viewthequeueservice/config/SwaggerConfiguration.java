package com.jamesmhare.examples.viewthequeueservice.config;

import static springfox.documentation.builders.PathSelectors.ant;

import java.util.Collections;
import java.util.function.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Sets up the Docket for the Swagger docs.
 */
@Configuration
public class SwaggerConfiguration {

    @Bean
    public Docket swaggerSpringWebFluxPlugin() {
        final ApiInfo apiInfo = new ApiInfo(
                "View The Queue Service",
                "The View The Queue REST API allows clients to pull wait times and other information about" +
                        " Attractions, Restaurants and Shows at a Themed Entertainment Resort.",
                "1.0",
                "https://somedomain.com/some-team-name",
                new Contact("some-team-name", "https://somedomain.com", "support@somedomain.com"),
                "Proprietary License. All rights reserved.",
                "https://somedomain.com/some-license",
                Collections.emptyList()
        );

        final Predicate<String> path = ant("/v1/**");

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api")
                .useDefaultResponseMessages(false)
                .ignoredParameterTypes(Void.class)
                .select()
                .paths(path)
                .build()
                .apiInfo(apiInfo);
    }

}