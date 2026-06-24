package com.github.brunorafaeldev.api_web_first_project.doc;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    private Contact contato() {
        Contact contato = new Contact();
        contato.setName("Seu nome");
        contato.setUrl("http://www.meusite.com.br");
        contato.setEmail("voce@seusite.com.br");
        return contato;
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API Web")
                        .description("API Exemplo de uso de Springboot REST API")
                        .version("0.0.1-SNAPSHOT")
                        .contact(contato()));

    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("api-publica")
                .pathsToMatch("/**").build();

    }

}
