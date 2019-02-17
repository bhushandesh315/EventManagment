package com.bhushan.eventmanagement.EventManagmentSystem.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.Contact;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket produceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/Event.*"))
                .build().apiInfo(metadata());
    }

    // Describe your apis
    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Event Management Rest APIs")
                .description("This page lists all the rest apis for Event Management App.")
                .version("1.0-SNAPSHOT")
                .contact(new Contact("Bhushan Deshmukh", "https://github.com/bhushandesh315/EventManagment/tree/master/EventManagmentSystem", "bhushand315@gmail.com"))
                .build();

    }

    // Only select apis that matches the given Predicates.
    private Predicate<String> paths() {
// Match all paths except /error
        return Predicates.and(
                PathSelectors.regex("/Event.*"),
                Predicates.not(PathSelectors.regex("/error.*")));
    }
}