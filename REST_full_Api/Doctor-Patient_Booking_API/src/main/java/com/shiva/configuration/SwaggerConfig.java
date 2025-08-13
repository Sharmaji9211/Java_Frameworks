package com.shiva.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Doctor-Patient Booking API")
                .version("1.0")
                .description("API for managing doctor appointments")
                .contact(new Contact()
                    .name("API Support")
                    .email("support@bookingapi.com")
                    .url("https://bookingapi.com/contact"))
                .license(new License()
                    .name("Apache 2.0")
                    .url("https://www.apache.org/licenses/LICENSE-2.0.html"))
                .termsOfService("https://bookingapi.com/terms"));
    }


}