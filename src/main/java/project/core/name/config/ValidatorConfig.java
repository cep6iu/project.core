package project.core.name.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import project.core.name.utils.profile.PersonalDataValidator;
import project.core.name.utils.profile.UserValidator;

@Configuration
public class ValidatorConfig {
    @Bean
    public Validator userValidatorConfig() {
        return new UserValidator();
    }

    @Bean
    public Validator personalDataValidatorConfig() {
        return new PersonalDataValidator();
    }
}
