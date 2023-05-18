package com.example.Socialmediaapplication.DaoService;

import com.example.Socialmediaapplication.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User>users=new ArrayList<>();
    private static int userCount=0;
    public List<User>findAll(){
        return users;
    }
    public User findOne(int id){
        Predicate<? super User> predicate=user -> user.getId().equals(id);
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        return user;
    }
    public void deleteById(int id){
        Predicate<? super User> predicate=user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
