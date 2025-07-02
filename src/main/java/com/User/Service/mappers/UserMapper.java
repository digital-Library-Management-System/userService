package com.User.Service.mappers;


import com.User.Service.dto.BookResponseDto;
import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserResponseDto toDto(User users);

    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDate.now(java.time.ZoneOffset.UTC))")
    User toEntity(UserRequestDto usersDto);

    List<UserResponseDto> toDtoList(List<User> usersDto);
}
