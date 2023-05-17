package com.example.Socialmediaapplication.controller;

import com.example.Socialmediaapplication.DaoService.UserDaoService;
import com.example.Socialmediaapplication.Exception.UserNotFoundException;
import com.example.Socialmediaapplication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

        User user = service.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User save = service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
}
