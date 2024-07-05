package angular.spring.test.dao;

import angular.spring.test.constants.ApplicationConstants;
import angular.spring.test.entities.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {

    private Long id;

    @Size(min = ApplicationConstants.DataValidation.MIN_SIZE_PASSWORD, max = ApplicationConstants.DataValidation.MAX_SIZE_PASSWORD)
    @Column(name = "password")
    @NotBlank(message = "password cannot be empty")
    private String password;

    public static UserDao mapToUserDao (User user){

        return new UserDao(user.getId(), user.getPassword());
    }
}
