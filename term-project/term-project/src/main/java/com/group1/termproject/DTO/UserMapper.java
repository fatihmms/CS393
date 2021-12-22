package com.group1.termproject.DTO;

import com.group1.termproject.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    /*UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({@Mapping(source = "first_name", target = "name"),
               @Mapping(source = "last_name", target = "surname")})
    UserDTO userToUserDTO(User user);*/

}

