package com.example.fitclub.controller;

import com.example.fitclub.model.MyUser;
import com.example.fitclub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "admin/dashboard";
    }

    @GetMapping("/trainer/dashboard")
    public String trainerDashboard() {
        return "trainer/dashboard";
    }

    @GetMapping("/member/dashboard")
    public String memberDashboard() {
        return "member/dashboard";
    }

    @PostMapping("/admin/register")
    public String addUser(@ModelAttribute("user") MyUser user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/logout")
    public String logout(){
        return "redirect:/login";
    }

}