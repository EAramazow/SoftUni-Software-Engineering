package bg.softuni.errorhandling.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

@Configuration
public class ErrorConfig {

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver resolver = new SimpleMappingExceptionResolver();

        Properties exceptionMapping = new Properties();
        exceptionMapping.put(NullPointerException.class.getSimpleName(), "npe");

        resolver.setExceptionMappings(exceptionMapping);

        return resolver;
    }

}
