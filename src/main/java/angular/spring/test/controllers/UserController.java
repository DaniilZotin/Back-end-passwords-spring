package angular.spring.test.controllers;


import angular.spring.test.dao.UserDao;
import angular.spring.test.entities.User;
import angular.spring.test.servises.implementation.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/api/passwords")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    @GetMapping("all")
    public ResponseEntity<List<UserDao>> getPasswords(){
        List<UserDao> usersPasswords = userService.getUsersPasswords();

        return new ResponseEntity<>(usersPasswords, HttpStatus.OK);
    }


    @DeleteMapping("delete/all")
    public ResponseEntity<Map<String, String>> deleteUsers() {

        userService.deleteAllUsers();

        Map<String, String> map =  new TreeMap<>();
        map.put("result:", "you have deleted all users");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }


    @PostMapping("create")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDao userDao) {

        User newUser = userService.createUser(userDao);


        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
}
