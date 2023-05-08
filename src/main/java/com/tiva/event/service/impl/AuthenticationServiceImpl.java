package com.tiva.event.service.impl;

import com.tiva.event.dto.LoginDTO;
import com.tiva.event.dto.ResetPasswordDTO;
import com.tiva.event.jwt.JwtUtil;
import com.tiva.event.model.PasswordResetToken;
import com.tiva.event.model.User;
import com.tiva.event.repository.PasswordResetTokenRepository;
import com.tiva.event.service.AuthenticationService;
import com.tiva.event.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final PasswordResetTokenRepository passwordResetTokenRepository;
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtUtil jwtUtil;
    @Value("${event.app.forgotPassword.url}")
    private String forgotPasswordURL;


    public String authenticateIfValid(LoginDTO loginDTO) throws AuthenticationException {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.phone(),
                        loginDTO.password()
                )
        );
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return jwtUtil.generateToken(userDetails);
    }

    public void resetPassword(ResetPasswordDTO resetPasswordDTO) {
        PasswordResetToken passwordResetToken = passwordResetTokenRepository
                .findById(resetPasswordDTO.token())
                .orElseThrow(EntityNotFoundException::new);

        User user = passwordResetToken.getUser();
        userService.updatePassword(user, resetPasswordDTO.newPassword());
        passwordResetTokenRepository.delete(passwordResetToken);
    }


    public String generatePasswordResetURL(String email) {
        String token = createPasswordResetToken(email);

        return String.format("%s?token=%s", forgotPasswordURL, token);
    }

    private String createPasswordResetToken(String email) {
        User user = userService.getByEmail(email);
        String token = UUID.randomUUID().toString();
        PasswordResetToken passwordResetToken = PasswordResetToken
                .builder()
                .token(token)
                .user(user)
                .build();
        passwordResetTokenRepository.save(passwordResetToken);

        return token;
    }
}
