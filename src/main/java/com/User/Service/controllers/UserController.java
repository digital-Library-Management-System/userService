package com.User.Service.controllers;

import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import com.User.Service.mappers.UserMapper;

import com.User.Service.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="userService")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl usersServiceImpl;
    private final UserMapper userMapper;


    @PostMapping
    public ResponseEntity<UserResponseDto> createBook(@RequestBody UserRequestDto userRequestDto){

        User users = userMapper.toEntity(userRequestDto);
        UserResponseDto response = userMapper.toDto(usersServiceImpl.addUsers(users));

        return ResponseEntity.ok(response);

    }

    @GetMapping(path="{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String id){

        User users = usersServiceImpl.getById(id);
        UserResponseDto responseDto = userMapper.toDto(users);

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers(@RequestParam int page, @RequestParam int size){

        List<User> usersList = usersServiceImpl.getAll(page,size);
        List<UserResponseDto> responseDto = userMapper.toDtoList(usersList);

        return ResponseEntity.ok(responseDto);
    }

}
