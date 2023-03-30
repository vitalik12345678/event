package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum {

    administrator ("administrator"),
    USER ("user"),
    GUEST ( "guest");

    private final String value;

}
