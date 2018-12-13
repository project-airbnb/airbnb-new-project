package com.PKHS.airbnb.controller;

import com.PKHS.airbnb.model.User;
import com.PKHS.airbnb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model, String username, String password) {
        model.addAttribute("user", new User(username, password));
        return "home/login";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("user") User user) {
        if (user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            return "redirect:/admin";
        }
        return "redirect:/";
    }

    @GetMapping("/")
    public String home() {
        return "home/index";
    }

    @GetMapping("/admin")
    public String home_admin() {
        return "home/admin";
    }

    @GetMapping("/errors-403")
    public String errors() {
        return "errors-403";
    }
}
