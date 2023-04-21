package com.tiva.event.factory;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory implements EntityFactory<User, UserDTO> {

    @Override
    public UserDTO createDto (User user) {
        return null;
    }

    @Override
    public User createDTO (UserDTO userDTO) {
        return null;
    }
}
