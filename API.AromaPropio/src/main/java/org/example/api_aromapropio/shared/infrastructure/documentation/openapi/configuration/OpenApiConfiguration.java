package org.example.api_aromapropio.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI aromaPropioAPI() {
        // Creación del objeto OpenAPI con la información y documentación externa.
        return new OpenAPI()
                .info(new Info()
                        .title("Aroma Propio API")
                        .description("Aroma Propio Platform application REST API documentation.")
                        .version("v1.0.9")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Aroma Propio Platform wiki Documentation")
                        .url("https://aroma-propio-platform.wiki.github.io/docs"));
    }
}

