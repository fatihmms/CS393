package com.group1.termproject.mapper;

import com.group1.termproject.DTO.UserDTO;
import com.group1.termproject.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO userToDto(User user);
}
