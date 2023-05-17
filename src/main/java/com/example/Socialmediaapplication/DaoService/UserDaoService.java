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
    static {
        users.add(new User(++userCount,"adam", LocalDate.now().minusYears(30)));
        users.add(new User(++userCount,"Eve", LocalDate.now().minusYears(25)));
        users.add(new User(++userCount,"Jim", LocalDate.now().minusYears(20)));
        users.add(new User(++userCount,"mac", LocalDate.now().minusYears(15)));
        users.add(new User(++userCount,"maki", LocalDate.now().minusYears(10)));
    }
    public List<User>findAll(){
        return users;
    }
    public User findOne(int id){
        Predicate<? super User> predicate=user -> user.getId().equals(id);
        User user = users.stream().filter(predicate).findFirst().orElse(null);
        return user;
    }
    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;
    }
}
