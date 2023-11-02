package ro.mycode.evomarketapi.system.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {



    @Bean
    public ObjectMapper modelMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule());
    }
}
