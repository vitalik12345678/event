package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventTypeEnum {

    CONFERENCE ("conference"),
    WORKSHOP ("workshop"),
    SEMINAR ("seminar"),
    OTHER ("other"),
    PARTY ("party");

    private final String value;


}
