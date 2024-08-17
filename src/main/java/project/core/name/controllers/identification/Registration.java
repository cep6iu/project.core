package project.core.name.controllers.identification;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project.core.name.dto.identification.UserDTO;
import project.core.name.exceptions.indentification.RegistrationException;
import project.core.name.services.identification.UserService;
import project.core.name.utils.identification.UserValidator;

@Validated
@RestController
@RequestMapping("/registration")
public class Registration {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Qualifier("validator")
    @Autowired
    private Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @PostMapping("/api")
    public ResponseEntity<String> registrationByApi(@Valid @RequestBody UserDTO user, BindingResult result) {

        validator.validate(user, result);

        if (result.hasErrors()) {
            throw new RegistrationException(result.getFieldError().getDefaultMessage());
        } else {
           userService.saveUser(user);
           return ResponseEntity.ok("user saved successfully");
        }
    }

    @PostMapping("/form")
    public ResponseEntity<String> registrationByForm(@Valid @ModelAttribute UserDTO user, BindingResult result) {

        validator.validate(user, result);

        if (result.hasErrors()) {
            throw new RegistrationException(result.getFieldError().getDefaultMessage());
        } else {
            userService.saveUser(user);
            return ResponseEntity.ok("user saved successfully");
        }
    }

}
