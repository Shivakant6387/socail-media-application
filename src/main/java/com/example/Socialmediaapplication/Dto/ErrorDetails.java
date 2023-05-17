package com.example.Socialmediaapplication.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ErrorDetails {
    private LocalDateTime localDateTime;
    private String message;
    private String details;
}
