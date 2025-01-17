package angular.spring.test.repositories;

import angular.spring.test.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {


}
