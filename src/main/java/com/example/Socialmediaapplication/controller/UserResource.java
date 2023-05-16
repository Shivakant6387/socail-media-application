package com.example.Socialmediaapplication.controller;

import com.example.Socialmediaapplication.DaoService.UserDaoService;
import com.example.Socialmediaapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;
//    public UserResource(UserDaoService service){
//        this.service=service;
//    }
    @GetMapping("/users")
    public List<User>retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id);
    }
}
