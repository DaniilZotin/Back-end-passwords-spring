package angular.spring.test.entities;

import angular.spring.test.constants.ApplicationConstants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "\"user\"")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;


    @Size(min = ApplicationConstants.DataValidation.MIN_SIZE_PASSWORD, max = ApplicationConstants.DataValidation.MAX_SIZE_PASSWORD)
    @Column(name = "password")
    @NotBlank(message = "password cannot be empty")
    private String password;

    public User(String password){
        this.password = password;
    }
}
