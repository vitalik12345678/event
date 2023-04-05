package com.tiva.event.controller;

import com.tiva.event.model.User;
import com.tiva.event.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {

    private final UserService userService;

    @GetMapping
    public User test() {
        String phone = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        return userService.getUserByPhone(phone);

    }
}
