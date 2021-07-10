package com.mentor.crud.controller;

import com.mentor.crud.model.User;
import com.mentor.crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class MainRestController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;

    @Autowired
    public MainRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/allusers")
    public ResponseEntity<List<User>> list() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Integer id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/newUser")
    public ResponseEntity<String> addUserBd(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<String> update(@RequestBody User user) {
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
