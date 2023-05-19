package com.example.Socialmediaapplication.repository;

import com.example.Socialmediaapplication.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
