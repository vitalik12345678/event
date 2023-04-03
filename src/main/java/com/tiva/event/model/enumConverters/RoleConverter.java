package com.tiva.event.model.enumConverters;

import com.tiva.event.model.enums.RoleEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Locale;

@Converter
public class RoleConverter implements AttributeConverter<RoleEnum, String> {
//    public String convertToEnum(RoleEnum value) {
//        if(value == null) {
//            return null;
//        }
//        return value.getRole();
//    }

    @Override
    public String convertToDatabaseColumn(RoleEnum roleEnum) {
        if(roleEnum == null) {
            return null;
        }
        return roleEnum.getRole();
    }

    @Override
    public RoleEnum convertToEntityAttribute(String value) {
        if (value == null) {
            return null;
        }
        return RoleEnum.fromRole(value.toLowerCase(Locale.ROOT));
    }
}
