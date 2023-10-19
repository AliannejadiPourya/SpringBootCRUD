package com.pourya.example.service;

import com.pourya.example.data.model.User;
import com.pourya.example.data.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserService implements UserServiceInterface{
    private final UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUserByAge(String age) {
        return userRepository.findUsersByAge(age);
    }

    @Override
    public User getUserByZipcode(String zipcode) {
        return userRepository.findUserByZipcode(zipcode);
    }

    @Override
    public User addOrUpdateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
