package project.core.name.dto.identification;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import project.core.name.enums.indentification.UserRole;

@Data
public class UserDTO {

    @NotBlank(message = "The login mustn't be empty")
    @Length(min = 3, max = 20, message = "The login must be between 3 and 20 characters.")
    private String login;
    @NotBlank(message = "The password mustn't be empty")
    @Length(min = 3, max = 20,  message = "The password have to be between 3 and 20 characters ")
    private String password;
    private UserRole role;
    private PersonalDataDTO personalData;

}
