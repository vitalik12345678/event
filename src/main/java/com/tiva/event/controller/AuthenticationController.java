package com.tiva.event.controller;

import com.tiva.event.dto.ForgotPasswordDTO;
import com.tiva.event.dto.LoginDTO;
import com.tiva.event.dto.ResetPasswordDTO;
import com.tiva.event.dto.UserDTO;
import com.tiva.event.service.AuthenticationService;
import com.tiva.event.service.EmailService;
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

    private final AuthenticationService authenticationService;
    private final EmailService emailService;
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<UserDTO> signUp(@RequestBody UserDTO userDTO) {
        log.trace("signUp user '{}'", userDTO);

        UserDTO savedUserDTO = userService.create(userDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        log.trace("authentication for user '{}'", loginDTO.phone());

        String jwtToken = authenticationService.authenticateIfValid(loginDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(jwtToken);
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestBody ForgotPasswordDTO forgotPasswordDTO) {
        log.trace("Forgot password for user with email '{}'", forgotPasswordDTO.email());

        String url = authenticationService.generatePasswordResetURL(forgotPasswordDTO.email());
        emailService.sendPasswordResetEmail(forgotPasswordDTO, url);

        return ResponseEntity.status(HttpStatus.OK).body("A password reset email has been sent.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<String> resetPassword(@RequestBody ResetPasswordDTO resetPasswordDTO) {
        log.trace("Resetting password for user with token '{}'", resetPasswordDTO.token());

        authenticationService.resetPassword(resetPasswordDTO);

        return ResponseEntity.status(HttpStatus.OK).body("Password has been reset.");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Map<String, Object>> handleAuthenticationException(AuthenticationException e) {
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("message", "Authentication failed");
        errorResponse.put("details", e.getMessage());

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
    }


}
