package com.pourya.example.controller;

import com.pourya.example.data.model.User;
import com.pourya.example.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public User getUserById(@PathVariable Long id){
        log.info("getUserById in controller was called with id:{}", id);
        return userService.getById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        log.info("getAllUsers was called in controller.");
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/age/{age}")
    public List<User> getUsersByAge(@PathVariable String age) {
        log.info("getUsersByAge was called in controller with age:{}",age);
        return userService.getUserByAge(age);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/zip/{zipcode}")
    public User getUserByZipcode(@PathVariable String zipcode) {
        log.info("getUserByZipcode was called in controller with zip:{}",zipcode);
        return userService.getUserByZipcode(zipcode);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    User addOrUpdateUser(@RequestBody User user) {
        log.info("addOrUpdateUser was called in controller with user:{}",user);
        return userService.addOrUpdateUser(user);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return new ResponseEntity<>("The user got deleted.", HttpStatus.ACCEPTED);
    }

}
