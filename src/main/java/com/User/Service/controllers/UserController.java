package com.User.Service.controllers;

import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import com.User.Service.mappers.UsersMapper;
import com.User.Service.services.UserServiceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="userService")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl usersServiceImpl;
    private final UsersMapper usersMapper;

    @PostMapping
    public ResponseEntity<UserResponseDto> createBook(@RequestBody UserRequestDto usersRequestDto){

        User user = usersMapper.toEntity(usersRequestDto);
        UserResponseDto response = usersMapper.toDto(usersServiceImpl.addUsers(user));

        return ResponseEntity.ok(response);

    }

}
