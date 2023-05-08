package com.tiva.event.service.impl;

import com.tiva.event.dto.ForgotPasswordDTO;
import com.tiva.event.service.EmailService;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    @Override
    public void sendPasswordResetEmail(ForgotPasswordDTO forgotPasswordDTO, String url) {
        System.out.println(url);
        // TODO implement feature
    }
}
