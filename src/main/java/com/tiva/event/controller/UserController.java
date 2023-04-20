package com.tiva.event.controller;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.mapper.UserMapper;
import com.tiva.event.model.User;
import com.tiva.event.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        log.info("signup user '{}'", userDTO);

        User user = userMapper.dtoToModel(userDTO);
        user.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));

        return ResponseEntity.ok(userMapper.modelToDto(userRepository.save(user)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable(value = "id") Long id) {
        UserDTO userDTO = userMapper.modelToDto(userRepository.findById(id).orElseThrow());
        userRepository.deleteById(userDTO.getUserId());

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
