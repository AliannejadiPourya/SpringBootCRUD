package com.pourya.example.service;

import com.pourya.example.data.model.User;

import java.util.List;

public interface UserServiceInterface {
    User getById(Long id);
    List<User> getAllUsers();
    List<User> getUserByAge(String age);
    User getUserByZipcode(String zipcode);
    User addOrUpdateUser(User user);
    void deleteById(Long id);

}
