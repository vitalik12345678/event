package com.tiva.event.service;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
}
