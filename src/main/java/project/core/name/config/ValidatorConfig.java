package project.core.name.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import project.core.name.utils.identification.UserValidator;

@Configuration
public class ValidatorConfig {
    @Bean
    public Validator validator() {
        return new UserValidator();
    }
}
