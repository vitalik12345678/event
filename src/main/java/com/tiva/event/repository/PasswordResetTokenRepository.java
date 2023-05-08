package com.tiva.event.repository;

import com.tiva.event.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, String> {

    @Modifying
    @Transactional
    @Query("DELETE FROM PasswordResetToken prt WHERE prt.creationTime < ?1")
    void deleteExpiredTokens(Instant expirationThreshold);
}
