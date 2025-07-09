package com.User.Service.mappers;


import com.User.Service.UserBookList;
import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.data.domain.Pageable;


import java.util.List;

@Mapper(componentModel = "spring", uses = UserBookList.class)
public interface UserMapper {

    UserResponseDto toDto(User users);

    @Mapping(target = "registrationDate", expression = "java(java.time.LocalDate.now(java.time.ZoneOffset.UTC))")
    User toEntity(UserRequestDto usersDto);

    List<UserResponseDto> toDtoList(List<User> usersDto);

    @Mapping(target = "bookList", source = "user", qualifiedByName = "resolveBookListWithPageable")
    UserResponseDto toBookList(User user, @Context Pageable pageable);
}