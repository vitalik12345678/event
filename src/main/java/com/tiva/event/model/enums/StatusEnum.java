package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum StatusEnum {

    CREATED("CREATED"),
    APPROVED("APPROVED"),
    DECLINED("DECLINED"),
    WAITING("WAITING");

    private final String value;
}
