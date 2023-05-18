package com.example.Socialmediaapplication.repository;

import com.example.Socialmediaapplication.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
