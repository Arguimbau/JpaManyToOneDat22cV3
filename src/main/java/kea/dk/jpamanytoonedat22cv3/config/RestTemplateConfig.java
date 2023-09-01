package kea.dk.jpamanytoonedat22cv3.config;


import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestTemplateConfig
{
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        System.out.println("Configuring RestTemplateBuilder");
        return restTemplateBuilder.build();
    }
}
