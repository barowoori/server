package com.barowoori.foodpinbackend.config.doc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
                .version("v1.0.0")
                .title("푸드핀 API")
                .description("");

        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.APIKEY)
                .in(SecurityScheme.In.HEADER).name("Authorization");
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("Authorization"); // "Authorization"를 사용합니다.

        Components components = new Components().addSecuritySchemes("Authorization", securityScheme);


        return new OpenAPI()
                .components(components)
                .addSecurityItem(securityRequirement)
                .info(info);
    }
    @Bean
    public GroupedOpenApi all(){
        String[] pathsToMatch = {"/api/**"};
        return GroupedOpenApi.builder()
                .group("전체")
                .pathsToMatch(pathsToMatch)
                .build();
    }
}