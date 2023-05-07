package com.tiva.event.service;

import com.tiva.event.dto.LoginDTO;

public interface AuthenticationService {
    String authenticateIfValid(LoginDTO loginDTO);
}
