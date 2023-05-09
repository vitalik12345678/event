package com.tiva.event.service;

import com.tiva.event.dto.ForgotPasswordDTO;

public interface EmailService {

    void sendPasswordResetEmail(ForgotPasswordDTO forgotPasswordDTO, String url);

    void sendEmail(String to, String subject, String text);

}
