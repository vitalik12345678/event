package com.tiva.event.mappers;

import com.tiva.event.dto.UserDTO;
import com.tiva.event.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        User UserDTOToModel(UserDTO userDTO);
        UserDTO modelToUserDTO(User user);

}
