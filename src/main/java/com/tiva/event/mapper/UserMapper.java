package com.tiva.event.mapper;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface UserMapper {

    User dtoToModel(UserDTO userDTO);

    @Mapping(source = "createdDate", target = "createdDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "lastVisitedDate", target = "lastVisitedDate", dateFormat = "yyyy-MM-dd HH:mm:ss")
    UserDTO modelToDto(User user);

}
