package com.User.Service.controllers;

import com.User.Service.dto.UsersRequestDto;
import com.User.Service.dto.UsersResponseDto;
import com.User.Service.entities.Users;
import com.User.Service.mappers.UsersMapper;
import com.User.Service.services.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.ZoneOffset;

@RestController
@RequestMapping(path="userService")
@RequiredArgsConstructor
public class UserController {
    private final UsersServiceImpl usersServiceImpl;
    private final UsersMapper usersMapper;

    @PostMapping
    public ResponseEntity<UsersResponseDto> createBook(@RequestBody UsersRequestDto usersRequestDto){

        Users users = usersMapper.toEntity(usersRequestDto);
        users.setRegistrationDate(LocalDate.now(ZoneOffset.UTC)); // si tu veux le jour UTC
        users.setActive(false);

        UsersResponseDto  response = usersMapper.toDto(usersServiceImpl.addUsers(users));

        return ResponseEntity.ok(response);

    }

}
