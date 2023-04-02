package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum StatusEnum {

    created ("created"),
    approved ("approved"),
    declined ("declined"),
    waiting ("waiting");

    private final String value;
}
