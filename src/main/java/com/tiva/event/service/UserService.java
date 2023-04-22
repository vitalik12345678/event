package com.tiva.event.service;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.mapper.UserMapper;
import com.tiva.event.model.User;
import com.tiva.event.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;

    public UserDTO create(UserDTO userDTO) {
        User user = userMapper.dtoToModel(userDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        user = userRepository.save(user);

        return userMapper.modelToDto(user);
    }

    public void delete(Long id) {
        UserDTO userDTO = userMapper.modelToDto(userRepository.findById(id).orElseThrow());
        userRepository.deleteById(userDTO.getUserId());
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new UsernameNotFoundException("Do not found user with phone" + phone));
    }


}
