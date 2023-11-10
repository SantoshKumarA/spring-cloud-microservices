package com.santosh.socialmediaservice.dao;

import com.santosh.socialmediaservice.entity.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();
    private static int userIdCount = 0;

    static {
        users.add(new User(++userIdCount, "Santosh", LocalDate.now().minusYears(30)));
        users.add(new User(++userIdCount, "Kumar", LocalDate.now().minusYears(25)));
        users.add(new User(++userIdCount, "A", LocalDate.now().minusYears(20)));
    }

    public List<User> findAllUsers() {
        return users;
    }

    public User findUser(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User createUser(User user) {
        user.setId(++userIdCount);
        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }
}
