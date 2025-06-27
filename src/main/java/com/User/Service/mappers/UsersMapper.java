package com.User.Service.mappers;


import com.User.Service.dto.UsersRequestDto;
import com.User.Service.dto.UsersResponseDto;
import com.User.Service.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    UsersResponseDto toDto(Users users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDate.now(java.time.ZoneOffset.UTC))")
    @Mapping(target = "active", constant = "false")
    Users toEntity(UsersRequestDto usersDto);

    List<UsersResponseDto> toDtoList(List<Users> usersDto);
}
