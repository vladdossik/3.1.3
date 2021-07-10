package com.mentor.crud.service;

import com.mentor.crud.model.User;
import com.mentor.crud.repo.RoleRepository;
import com.mentor.crud.repo.UserRepository;
import org.hibernate.Hibernate;
import org.hibernate.type.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User show(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public User findByUserName(String userName) {
        User user = userRepository.findByUserName(userName);
        return user;
    }
}
