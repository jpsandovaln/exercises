package com.problem1.webservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger configuration class.
 * @author Paolo Sandoval
 * @version 1.0
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    /**
     * Enable swagger documentation
     * @return the documentation.
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.problem1.webservice.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(addInfo());
    }

    /**
     * Adds custom information.
     * @return the new information.
     */
    public ApiInfo addInfo() {
       return new ApiInfoBuilder()
               .title("Problem 1 Documentation")
               .description("Api Documentation for Problem 1")
               .termsOfServiceUrl("localhost")
               .version("1.0")
               .contact(new Contact("Paolo Sandoval", "localhost","paolosandovaln@gmail.com"))
               .build();
    }
}
