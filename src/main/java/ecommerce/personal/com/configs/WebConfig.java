package ecommerce.personal.com.configs;

import ecommerce.com.lib.annotations.impl.SearchAttributeResolver;
import ecommerce.com.lib.annotations.impl.ValueInListImpl;
import ecommerce.com.lib.utils.BeanUtils;
import ecommerce.personal.com.interceptors.AuditInterceptor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class WebConfig implements WebMvcConfigurer {
    private final SearchAttributeResolver searchAttributeResolver;
    private final AuditInterceptor auditInterceptor;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(searchAttributeResolver);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(auditInterceptor);
    }

    @Autowired
    public void beanUtils(PropertyResolver property){
        log.info("WebConfig | beanUtils | property");
        BeanUtils.setBean(property);
    }
}
