package com.ukdw.api.config

import com.google.common.base.Predicate
import com.google.common.base.Predicates
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@ComponentScan(value = "com.ukdw.api.controller")
class SwaggerConfig {

    @Bean
    open fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
               .groupName("UKDW Phonebook")
               .select()
               .apis(RequestHandlerSelectors.any())
               .paths(paths())
               .build()
               .apiInfo(apiInfo())
    }

    private fun paths(): Predicate<String> = Predicates.not(PathSelectors.regex("/error"))

    private fun apiInfo(): ApiInfo {
        val title = "UKDW Phonebook"
        val description = "UKDW Phonebook API Documentation"
        val apiVersion = "1.0"

        return ApiInfo(title, description, apiVersion, "", contact(), "", "")
    }

    private fun contact(): Contact {
        val name = "Gojek Team"
        val email = "budi.suryanto@go-jek.com"
        val url = "https://go-jek.com"

        return Contact(name, url, email)
    }
}