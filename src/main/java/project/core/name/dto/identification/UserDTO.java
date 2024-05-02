package project.core.name.dto.identification;

import lombok.*;
import project.core.name.enums.indentification.UserRole;

@Data
public class UserDTO {

    private String login;
    private String password;
    private UserRole role;
    private PersonalDataDTO personalData;

}
