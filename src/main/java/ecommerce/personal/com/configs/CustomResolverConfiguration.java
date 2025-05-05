package ecommerce.personal.com.configs;

import ecommerce.com.lib.annotations.impl.SearchAttributeResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomResolverConfiguration {
    @Bean
    public SearchAttributeResolver searchAttributeResolver() {
        return new SearchAttributeResolver();
    }
}
