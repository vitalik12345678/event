package com.tiva.event.service;


import com.tiva.event.dto.LoginDTO;
import com.tiva.event.dto.ResetPasswordDTO;
import org.springframework.security.core.AuthenticationException;

public interface AuthenticationService {

    String authenticateIfValid(LoginDTO loginDTO) throws AuthenticationException;

    void resetPassword(ResetPasswordDTO resetPasswordDTO);

    String generatePasswordResetURL(String email);

