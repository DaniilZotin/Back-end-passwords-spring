package angular.spring.test.servises.implementation;

import angular.spring.test.dao.UserDao;
import angular.spring.test.entities.User;

import java.util.List;

public interface UserService {
    List<UserDao> getUsersPasswords();

    void deleteAllUsers();

    User createUser(UserDao userDao);
}
