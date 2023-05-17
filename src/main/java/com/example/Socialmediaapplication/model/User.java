package com.example.Socialmediaapplication.model;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    @Size(min = 2 , message = "Name should have at least 2 characters ")
    private String name;
    @Past(message = "Birth Date should be in the past")
    private LocalDate birthDate;
}
