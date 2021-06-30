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

import java.util.List;

@Controller
public class SubscriptionController {

    @Autowired
    private UserService userService;

    @GetMapping("/mySubscription")
    public String getMySubscriptionPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<UserDto> users = userService.findSubscription(userDetails.getUser().getId());
        model.addAttribute("users", users);
        return "mySubscriptions";
    }

}
