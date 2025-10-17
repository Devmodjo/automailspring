package com.victormodjo.automaticMail.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Mail Automation API",
                version = "1.0",
                contact = @Contact(name = "by Modjo Victor", email = "yvankamsu88@gmail.com", url = "https://modjovictor.vercel.app"),
                description = "cette api permet d'envoi l'heure automatique aux utilisateur inscrits"
        )

)
public class OpenApiConfig {
}
