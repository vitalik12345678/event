package com.tiva.event.factory;

public interface EntityFactory <Entity ,DTO> {

    DTO createDto(Entity entity);

    Entity createDTO(DTO dto);

}
