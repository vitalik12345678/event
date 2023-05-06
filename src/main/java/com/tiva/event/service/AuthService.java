package com.tiva.event.service;

import com.tiva.event.dto.LoginDTO;

public interface AuthService {
    String authenticateIfValid(LoginDTO loginDTO);
}
