package com.simbirsoft.habbitica.impl.controllers;

import com.simbirsoft.habbitica.api.services.UserService;
import com.simbirsoft.habbitica.impl.models.data.User;
import com.simbirsoft.habbitica.impl.models.dto.UserDto;
import com.simbirsoft.habbitica.impl.security.details.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<UserDto> users = userService.findAllByUser(userDetails.getUser().getId());
        model.addAttribute("users", users);
        return "users_page";
    }

    @GetMapping("/users/{user-id}")
    public String addUser(@PathVariable("user-id") Long user_id, @AuthenticationPrincipal UserDetailsImpl userDetails){
        userService.addUser(user_id, userDetails.getUser().getId());
        return "redirect:/users";
    }

}
