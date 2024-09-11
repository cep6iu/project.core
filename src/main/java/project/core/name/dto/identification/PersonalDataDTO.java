package project.core.name.dto.identification;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class PersonalDataDTO {

    @NotBlank(message = "The name field cannot be blank")
    @Size(min = 2, max = 20, message = "The name must contain between {min} and {max} characters")
    private String name;
    @NotBlank(message = "The name field cannot be blank")
    @Size(min = 2, max = 20, message = "The name must contain between {min} and {max} characters")
    private String surname;
    //  @NotBlank(message = "The gender field cannot be blank.")
    // @Size(min = 1, max = 1, message = "The gender must contain exactly 1 character.")
  //  @Pattern(regexp = "^[WM]$", message = "You should put in this field only W or M")
    private Character gender;
    @Past(message = "The date of birth must be in the past.")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @Email(message = "Please enter a valid email address")
    private String email;
    private String phoneNumber;

}
