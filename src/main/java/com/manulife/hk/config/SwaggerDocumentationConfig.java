package com.manulife.hk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Configuration
public class SwaggerDocumentationConfig {

	 ApiInfo apiInfo() {
            return new ApiInfoBuilder()
                    .title("API Store - hk-aks-demo-java-maven")
                    .description("Swagger file for REST Endpoints")
                    .license("Manulife Asia HongKong")
                    .licenseUrl("http://www.manulife.com")
                    .termsOfServiceUrl("")
                    .version("1.0.3-SNAPSHOT")
                    .contact(new Contact("", "", "Jeffrey_W_Li@manulife.com"))
                    .build();
        }

        @Bean
        @Primary
        public Docket customImplementation() {
            return new Docket(DocumentationType.SWAGGER_2)
                    .select()
                    .apis(RequestHandlerSelectors.basePackage("com.manulife.hk.controller"))
                    .build()
                    .directModelSubstitute(LocalDate.class, java.sql.Date.class)
                    .directModelSubstitute(LocalDateTime.class, java.util.Date.class)
                    .apiInfo(apiInfo());
        }
}
