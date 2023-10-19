package com.pourya.example.data.repository;

import com.pourya.example.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    List<User> findUsersByAge(String age);
    User findUserByZipcode(String zipcode);
}
