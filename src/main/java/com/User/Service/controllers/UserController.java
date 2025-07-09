package com.User.Service.controllers;

import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import com.User.Service.mappers.UserMapper;

import com.User.Service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="userService")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto){

        User users = userMapper.toEntity(userRequestDto);
        UserResponseDto response = userMapper.toDto(userService.addUsers(users));

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String id, Pageable pageable){

        User users = userService.getById(id);
        UserResponseDto responseDto =  userMapper.toBookList(users, pageable);

        return ResponseEntity.ok(responseDto);
    }


    @GetMapping
    public Page<UserResponseDto> getAll(Pageable pageable){

        Page<User> usersPage = userService.getAll(pageable);
        List<UserResponseDto> dtoList = userMapper.toDtoList(usersPage.getContent());

        return new PageImpl<>(dtoList, pageable, usersPage.getTotalElements());
    }

    @GetMapping("/all")
    public List<UserResponseDto> getAllUsers(){

        List<User> user = userService.getAllUsers();
        return userMapper.toDtoList(user);
    }

}