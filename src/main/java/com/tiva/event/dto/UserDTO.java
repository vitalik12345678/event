package com.tiva.event.dto;

import com.tiva.event.model.enums.RoleEnum;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@ToString
public class UserDTO {

    private Long userId;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    @Length(min = 7, max = 25)
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{7,25}$")
//                (?=.*[0-9])       # a digit must occur at least once
//                (?=.*[a-z])       # a lower case letter must occur at least once
//                (?=.*[A-Z])       # an upper case letter must occur at least once
//                (?=.*[@#$%^&+=])  # a special character must occur at least once
//                (?=\S+$)          # no whitespace allowed in the entire string
//                .{7,25}           # anything, at least 7 places max 25 places

    private String password;
    private RoleEnum role;
    private String email;
    //All Ukraine numbers with or without +38, without whitespaces and any other characters between digits
    @Pattern(regexp = "^\\+?3?8?(0\\d{9})$")
    private String phone;
    private String createdDate;
    private String lastVisitedDate;
    private String blockedDate;

}
