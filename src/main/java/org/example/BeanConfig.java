package org.example;

import ch.qos.logback.core.model.Model;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanConfig {
    @Bean
    public  ModelMapper getModelMapper(){
        return new ModelMapper();
    }
}
