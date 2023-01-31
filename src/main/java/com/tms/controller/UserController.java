package com.tms.controller;

import com.tms.domain.User;
import com.tms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(@RequestParam int id, @RequestParam String firstname, Model model){
        User user = userService.createUser(id, firstname);
        //класть в JSP
        model.addAttribute("id", user.getId());
        model.addAttribute("firstname", user.getFirstName());
        model.addAttribute("user", user);
        model.addAttribute("message", "Programmer Gate");
        return "createUser";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable int id) {
        userService.getUser(id);
        return "userJSP";
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String delete(@PathVariable int id){
        return "GOOD";
    }
}