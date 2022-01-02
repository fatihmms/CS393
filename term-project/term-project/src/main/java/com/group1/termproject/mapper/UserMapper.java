package com.group1.termproject.mapper;

import com.group1.termproject.DTO.UserDTO;
import com.group1.termproject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class);

    /*@Mapping(source = "first_name", target = "name")
    @Mapping(source = "last_name", target =  "surname")
    UserDTO userToDto(User user);

    @Mapping(target = "first_name", source = "name")
    @Mapping(target = "last_name", source = "surname")
    User dtoToUser(UserDTO userDTO);*/
}
