package com.tiva.event.dto;

import com.tiva.event.model.enums.RoleEnum;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    private String password;
    private RoleEnum role;
    private String email;
    private String phone;
    private String createdDate;
    private String lastVisitedDate;
    private String blockedDate;

}
