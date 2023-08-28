package com.todolist.configurations

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun todoListOpenApi(): OpenAPI =
        OpenAPI()
            .info(
                Info()
                    .title("TO-DO List Api")
                    .description("Simple TO-DO list api use kotlin and spring boot")
                    .version("1.0.0")
            )
}