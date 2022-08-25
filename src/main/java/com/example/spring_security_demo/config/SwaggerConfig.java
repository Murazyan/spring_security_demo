package com.example.spring_security_demo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    final String securitySchemeName = "bearerAuth";
    return new OpenAPI()
      .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
      .components(
        new Components()
          .addSecuritySchemes(securitySchemeName,
            new io.swagger.v3.oas.models.security.SecurityScheme()
              .name(securitySchemeName)
              .type(SecurityScheme.Type.HTTP)
              .scheme("bearer")
              .bearerFormat("JWT")
          )
      )
      .info(apiInfo());
  }

  private Info apiInfo() {
    return new Info()
      .title("Security demo  REST API")
      .description("Security demo  applications rest API")
      .version("0.0.1")
      .contact(new io.swagger.v3.oas.models.info.Contact().name("Example").url("https://www.example.am/").email("info@example.am"))
      .license(new License().name("License of API"));
  }
}