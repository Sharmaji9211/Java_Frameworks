package com.shiva;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class DoctorPatientBookingApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoctorPatientBookingApiApplication.class, args);
    }
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
            .setSkipNullEnabled(true)
            .setFieldMatchingEnabled(true);
        return mapper;
    }
}