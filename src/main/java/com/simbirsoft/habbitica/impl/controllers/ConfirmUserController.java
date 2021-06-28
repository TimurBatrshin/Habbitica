package com.simbirsoft.habbitica.impl.controllers;

import com.simbirsoft.habbitica.api.services.ConfirmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmUserController {

    private ConfirmUserService confirmUserService;

    @Autowired
    public ConfirmUserController(ConfirmUserService confirmUserService) {
        this.confirmUserService = confirmUserService;
    }

    @GetMapping("/confirm/{code}")
    public String confirm(@PathVariable("code") String code) {

        confirmUserService.confirmUserByToken(code);

        return "success_page";
    }
}