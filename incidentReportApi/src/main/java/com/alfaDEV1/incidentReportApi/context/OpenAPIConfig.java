package com.alfaDEV1.incidentReportApi.context;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI myOpenAPI() {

        Contact contact = new Contact();
        contact.setEmail("alfarollano@gmail.com"); // Cambiado a setEmail en lugar de email
        contact.setName("alfaDEV1"); // Cambiado a setName en lugar de Name
        contact.setUrl("https://github.com/alfadev1"); // Cambiado a setUrl en lugar de Url

        License mitLicense = new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title("Practica APIRest-SpringBoot")
                .version("1")
                .contact(contact)
                .description("Practica de anotaciones y mapeado de entidades.")
                .termsOfService("https://www.example.com/terms")
                .license(mitLicense);

        return new OpenAPI().info(info); // No es necesario castear a io.swagger.v3.oas.models.info.Info
    }
}