package ir.efarda.transliterate;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * @author Erfan Akhavan Rad
 * @created 12/04/2024
 */
@Configuration
public class RestTemplateConfig {
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.messageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

}
