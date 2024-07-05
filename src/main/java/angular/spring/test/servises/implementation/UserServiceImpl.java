package angular.spring.test.servises.implementation;

import angular.spring.test.dao.UserDao;
import angular.spring.test.entities.User;
import angular.spring.test.exceptions.exceptions.UsersNotFoundException;
import angular.spring.test.repositories.UserRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;




    @Override
    public List<UserDao> getUsersPasswords() {
        List<UserDao> usersPasswords = userRepo.findAll().stream().map(UserDao::mapToUserDao).collect(Collectors.toList());

        if (usersPasswords.isEmpty()) {
            throw new UsersNotFoundException("Users and passwords were not found");
        }

        return usersPasswords;

    }

    @Override
    public void deleteAllUsers() {
        userRepo.deleteAll();
    }

    @Override
    public User createUser(UserDao userDao) {

        User newUser = new User(userDao.getPassword());

        userRepo.save(newUser);



        return userRepo.save(newUser);
    }
}

