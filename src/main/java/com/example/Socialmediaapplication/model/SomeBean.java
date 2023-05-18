package com.example.Socialmediaapplication.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"field1","field2"})
public class SomeBean {
    private String field1;
    private String field2;
 //   @JsonIgnore
    private String field3;


}
