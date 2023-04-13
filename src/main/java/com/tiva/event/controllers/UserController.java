package com.tiva.event.controllers;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.mappers.UserMapper;
import com.tiva.event.model.User;
import com.tiva.event.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


//    @GetMapping("/user/{id}")
//    public ResponseEntity<UserDTO> getUser(@PathVariable(value = "id") Long id) {
//        return new ResponseEntity<>(
//                userMapper.modelToUserDTO(userRepository.findById(id).get()
//                ), HttpStatus.OK);
//    }

    @PostMapping("/user/registration")
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO) {
        userDTO.setCreatedDate(LocalDateTime.now());
        return new ResponseEntity<>(
                userRepository.save(userMapper.UserDTOToModel(userDTO)
                ), HttpStatus.OK);
    }
}
