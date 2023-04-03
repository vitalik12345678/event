package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum {
    ADMINISTRATOR ("administrator"),
    user ("user"),
    guest ("guest");

    private final String role;

    public static RoleEnum fromRole(String _role) {
        RoleEnum roleEnum = null;
        if (_role.equals("administrator") || _role.equals("ADMINISTRATOR")) {
            roleEnum = RoleEnum.ADMINISTRATOR;
        } else if (_role.equals("user") || _role.equals("USER")) {
            return user;
        } else if (_role.equals("guest") || _role.equals("GUEST")) {
            return guest;
        }
        return roleEnum;
//        throw new UnsupportedOperationException("This role " + _role + " is not supported!");
    }
 }
