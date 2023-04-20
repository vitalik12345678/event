package com.tiva.event.dto;

import com.tiva.event.model.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@Builder
@ToString
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    private String password;
    private RoleEnum role;
    private String email;
    private String phone;
    private LocalDateTime createdDate;
    private LocalDateTime lastVisitedDate;
    private LocalDateTime blockedDate;

}
