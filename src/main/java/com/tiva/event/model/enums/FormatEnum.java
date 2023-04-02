package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum FormatEnum {

    ONLINE ("online"),
    OFFLINE ("offline"),
    UNSPECIFIED ("unspecified");

    private final String value;
}
