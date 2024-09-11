package project.core.name.entities.identification;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "personal_data")
public class PersonalData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    private User user;
    private String name;
    private String surname;
    private Character gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
}
