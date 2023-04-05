package com.tiva.event.service;

import com.tiva.event.model.User;
import com.tiva.event.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User getUserByPhone(String phone) {
        return userRepository.findByPhone(phone)
                .orElseThrow(() -> new EntityNotFoundException("Do not found user with phone" + phone));
    }


//    @Bean
//    public CommandLineRunner createUsers(UserService userService) {
//        return args -> {
//            User user1 = new User();
//            user1.setFirstName("John");
//            user1.setLastName("Doe");
//            user1.setEmail("john.doe@example.com");
//            user1.setPhone("1234567890");
//            user1.setPassword(new BCryptPasswordEncoder().encode("password"));
//            user1.setRole(RoleEnum.USER);
//
//            User user2 = new User();
//            user2.setFirstName("Jane");
//            user2.setLastName("Doe");
//            user2.setEmail("jane.doe@example.com");
//            user2.setPhone("0987654321");
//            user2.setPassword(new BCryptPasswordEncoder().encode("password"));
//            user2.setRole(RoleEnum.ADMINISTRATOR);
//
//            userService.create(user1);
//            userService.create(user2);
//        };
//    }

}
