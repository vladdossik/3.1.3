package com.mentor.crud.service;

import com.mentor.crud.model.User;

import javax.transaction.Transactional;
import java.util.List;
@Transactional
public interface UserService {
    List<User> getAllUsers();

    void save(User user);

    User show(int id);

    void update(User user);

    void delete(int id);

    User findByUserName(String userName);
}
