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
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;


    @GetMapping(value = "/admin")
    public String showAllUsers(ModelMap model) {
        List<User> list = userService.getAllUsers();
        model.addAttribute("allRoles", roleService.getAllRoles());
        model.addAttribute("allUsers", list);
        model.addAttribute("addUser", new User());
        model.addAttribute("allRoles", roleService.getAllRoles());
        return "users";
    }

    @GetMapping(value = "/user")
    public String user() {
        return "userPage";
    }


    @GetMapping(value = "/admin/new")
    public String addUser(ModelMap modelMap) {
        modelMap.addAttribute("addUser", new User());
        modelMap.addAttribute("allRoles", roleService.getAllRoles());
        return "users";
    }

    @PostMapping(value = "/admin")
    public String addUserBd(@ModelAttribute("addUser") User user,
                            @RequestParam(value = "select_role", required = false) String[] role) {
        Set<Role> rol = new HashSet<>();
        for (String s : role) {
            rol.add(roleService.findByRole(s));
        }

        user.setRoles(rol);
        userService.save(user);
        return "redirect:/admin";
    }


    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user,
                         @RequestParam(value = "select_roles", required = false) String[] roles) {
        userService.update(user,roles);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) {
        userService.delete(id);
        return "redirect:/admin";
    }
}
