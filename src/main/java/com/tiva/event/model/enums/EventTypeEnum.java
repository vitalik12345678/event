package com.tiva.event.model.enums;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum EventTypeEnum {

    CONFERENCE ("CONFERENCE"),
    WORKSHOP ("WORKSHOP"),
    SEMINAR ("SEMINAR"),
    OTHER ("OTHER"),
    PARTY ("PARTY");

    private final String value;


}
