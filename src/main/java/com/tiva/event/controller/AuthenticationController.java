package com.tiva.event.controller;

import com.tiva.event.dto.LoginDTO;
import com.tiva.event.dto.UserDTO;
import com.tiva.event.service.AuthenticationService;
import com.tiva.event.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;
    private final AuthenticationService authenticationService;


    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
        log.info("signUp user '{}'", userDTO);

        UserDTO savedUserDTO = userService.create(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        log.trace("authentication for user '{}'", loginDTO.phone());

        String jwtToken = authenticationService.authenticateIfValid(loginDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(jwtToken);
    }


}
