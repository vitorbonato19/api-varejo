package br.com.localvarejo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigDefault {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
