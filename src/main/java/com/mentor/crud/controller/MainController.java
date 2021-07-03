package com.mentor.crud.controller;

import com.mentor.crud.model.Role;
import com.mentor.crud.model.User;
import com.mentor.crud.service.RoleServiceImpl;
import com.mentor.crud.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("")
public class MainController {
    @GetMapping(value = "/admin")
    public String showAllUsers(ModelMap model) {
        return "users";
    }

    @GetMapping(value = "/user")
    public String user() {
        return "userPage";
    }


    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "select_roles", required = false) String[] role) {
        return "redirect:/admin";
    }
}
