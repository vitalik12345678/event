package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum {

    ADMINISTRATOR ("admin"),
    USER ("user"),
    GUEST ( "guest");

    private final String value;

}
