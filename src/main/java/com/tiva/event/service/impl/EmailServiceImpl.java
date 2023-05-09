package com.tiva.event.service.impl;

import com.tiva.event.dto.ForgotPasswordDTO;
import com.tiva.event.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    private final static String RESET_PASSWORD = "Reset password for event account";
    @Override
    public void sendPasswordResetEmail(ForgotPasswordDTO forgotPasswordDTO, String url) {
        System.out.println(url);
        // TODO implement feature
        sendEmail(forgotPasswordDTO.email(), RESET_PASSWORD, url);
    }

    @Override
    public void sendEmail(String to, String subject, String text) {

    }
}
