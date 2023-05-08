package com.tiva.event.service;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.mapper.EntityMapper;
import com.tiva.event.model.User;
import com.tiva.event.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final EntityMapper entityMapper;

    public UserDTO create(UserDTO userDTO) {
        User user = entityMapper.dtoToModel(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user = userRepository.save(user);

        return entityMapper.modelToDto(user);
    }

    public void delete(Long id) {
        UserDTO userDTO = entityMapper.modelToDto(userRepository.findById(id).orElseThrow());
        userRepository.deleteById(userDTO.getUserId());
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new UsernameNotFoundException("Do not found user with phone" + phone));
    }


    public User getByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("Do not found user with email" + email));
    }

    public void updatePassword(User user, String newPassword) {
        user.setPassword(passwordEncoder.encode(newPassword));

        userRepository.save(user);
    }
}
