package com.tiva.event.controller;

import com.tiva.event.jwt.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class Controller {

    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity<String> test() {
        log.info("test");

        String phone = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
        UserDetails userDetails = userDetailsService.loadUserByUsername(phone);
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(token);
    }
}
