package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum RoleEnum {

    ADMINISTRATOR ("ADMINISTRATOR"),
    USER ("USER"),
    GUEST ( "GUEST");

    private final String value;

}
