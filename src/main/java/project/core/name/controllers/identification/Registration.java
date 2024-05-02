package project.core.name.controllers.identification;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import project.core.name.dto.identification.UserDTO;
import project.core.name.services.identification.UserService;
import project.core.name.utils.identification.UserValidator;

@Validated
@RestController
@RequestMapping("/identification")
public class Registration {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserService userService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @PostMapping("/registration")
    public ResponseEntity<String> registration(@Valid @RequestBody UserDTO user, BindingResult result) {

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("login is already in use");
        } else {
           userService.saveUser(user);
           return ResponseEntity.ok("user saved successfully");
        }
    }

}
