package com.User.Service.mappers;


import com.User.Service.dto.UsersRequestDto;
import com.User.Service.dto.UsersResponseDto;
import com.User.Service.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "id", expression = "java(users.getId().toHexString())")
    UsersResponseDto toDto(Users users);

    @Mapping(target = "id", ignore = true)
    Users toEntity(UsersRequestDto usersDto);
    List<UsersResponseDto> toDtoList(List<Users> usersDto);


}
