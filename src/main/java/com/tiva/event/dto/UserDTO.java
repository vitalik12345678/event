package com.tiva.event.dto;

import com.tiva.event.model.enums.RoleEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String password;
    private RoleEnum role;
    private String email;
    private String phone;
    private LocalDateTime createdDate;

}
