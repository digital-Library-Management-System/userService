package com.User.Service.mappers;


import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDate.now(java.time.ZoneOffset.UTC))")
    UserResponseDto toDto(User users);

    User toEntity(UserRequestDto usersDto);

    List<UserResponseDto> toDtoList(List<User> usersDto);


}
