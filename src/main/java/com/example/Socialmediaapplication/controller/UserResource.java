package com.example.Socialmediaapplication.controller;

import com.example.Socialmediaapplication.DaoService.UserDaoService;
import com.example.Socialmediaapplication.Exception.UserNotFoundException;
import com.example.Socialmediaapplication.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api")
public class UserResource {
    @Autowired
    private UserDaoService service;
    @GetMapping("/users")
    public List<User>retrieveAllUsers(){
        return service.findAll();
    }
    @GetMapping("/usersId/{id}")
    public EntityModel< User> retrieveUserById(@PathVariable int id){

        User user = service.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id:"+id);
        EntityModel<User>entityModel=EntityModel.of(user);
        WebMvcLinkBuilder link=linkTo(methodOn(this.getClass()).retrieveAllUsers());
        entityModel.add(link.withRel("all-users"));
        return entityModel;
    }
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){

        User user = service.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User save = service.save(user);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        service.deleteById(id);
    }
}
