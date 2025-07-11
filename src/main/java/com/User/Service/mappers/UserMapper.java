package com.User.Service.mappers;


import com.User.Service.BookClient;
import com.User.Service.dto.BookResponseDto;
import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    protected  BookClient bookClient;

    @Mapping(target = "bookList", expression = "java(bookClient.getAll())")
    public abstract UserResponseDto toDto(User user);

    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDate.now(java.time.ZoneOffset.UTC))")
    public abstract User toEntity(UserRequestDto usersDto);

    public abstract List<UserResponseDto> toDtoList(List<User> usersDto);

}