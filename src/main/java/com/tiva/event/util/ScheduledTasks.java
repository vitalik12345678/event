package com.tiva.event.util;

import com.tiva.event.repository.PasswordResetTokenRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
@RequiredArgsConstructor
public class ScheduledTasks {

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    @Value("${event.app.resetPassword.token.expiration}")
    private long tokenDuration;

    @Scheduled(fixedRate = 3600000)
    public void deleteExpiredTokens() {
        Instant expirationThreshold = Instant.now().minus(Duration.ofMinutes(tokenDuration));
        passwordResetTokenRepository.deleteExpiredTokens(expirationThreshold);

        log.info("Deleted expired password reset tokens");
    }
}
