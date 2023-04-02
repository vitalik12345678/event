package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventTypeEnum {

    conference ("conference"),
    workshop ("workshop"),
    seminar ("seminar"),
    other ("other"),
    party ("party");

    private final String value;


}
