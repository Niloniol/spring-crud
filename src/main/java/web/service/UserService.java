package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void remove(User user);
    User getById(Long id);
    void update(User user);
    List<User> listUsers();
}
