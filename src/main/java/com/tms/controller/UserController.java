package com.tms.controller;

import com.tms.domain.User;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable int id, ModelMap model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userJSP";
    }

    @GetMapping
    public String getAllUsers(ModelMap model) {
        ArrayList<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "allUsers";
    }

    @PostMapping
    public String createUser(@RequestParam String firstName,
                             @RequestParam String lastName,
                             @RequestParam int age,
                             @RequestParam String login,
                             @RequestParam String password) {
        int result = userService.createUser(firstName, lastName, age, login, password);
        return result > 0 ? "success" : "unsuccess";
    }

    @PutMapping
    @ResponseBody
    public String updateUserById(@RequestParam int id,
                                 @RequestParam String firstName,
                                 @RequestParam String lastName,
                                 @RequestParam int age,
                                 @RequestParam String login,
                                 @RequestParam String password) {
        int result = userService.updateUserById(id, firstName, lastName, age, login, password);
        return result > 0 ? "User was updated!" : "User wasn't updated!";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable int id) {
        int result = userService.deleteUserById(id);
        return result > 0 ? "User was deleted!" : "User wasn't deleted!";
    }
}