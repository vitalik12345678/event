package com.tiva.event.service.impl;

import com.tiva.event.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.tiva.event.dto.ForgotPasswordDTO;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    private final static String RESET_PASSWORD = "Reset password for event account";
      
    @Override
    public void sendPasswordResetEmail(ForgotPasswordDTO forgotPasswordDTO, String url) {
        System.out.println(url);
        // TODO implement feature
        sendEmail(forgotPasswordDTO.email(), RESET_PASSWORD, url);
    }

    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
    }
}
