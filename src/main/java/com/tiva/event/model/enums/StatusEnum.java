package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum StatusEnum {

    CREATED ("created"),
    APPROVED ("approved"),
    DECLINED ("declined"),
    WAITING ("waiting");

    private final String value;
}