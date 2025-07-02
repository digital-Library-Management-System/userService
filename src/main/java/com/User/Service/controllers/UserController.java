package com.User.Service.controllers;

import com.User.Service.BookClient;
import com.User.Service.dto.BookResponseDto;
import com.User.Service.dto.UserRequestDto;
import com.User.Service.dto.UserResponseDto;
import com.User.Service.entities.User;
import com.User.Service.mappers.UserMapper;

import com.User.Service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="userService")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final BookClient bookClient;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createBook(@RequestBody UserRequestDto userRequestDto){

        User users = userMapper.toEntity(userRequestDto);
        UserResponseDto response = userMapper.toDto(userService.addUsers(users));

        return ResponseEntity.ok(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String id, Pageable pageable){

        User users = userService.getById(id);

        List<BookResponseDto> books =  bookClient.getAll(pageable);
        UserResponseDto responseDto =  userMapper.toDto(users);
        responseDto.setBookList(books);

        return ResponseEntity.ok(responseDto);
    }


    @GetMapping
    public Page<UserResponseDto> getAllUsers(Pageable pageable){

        Page<User> usersList = userService.getAll(pageable);
        return usersList.map(userMapper::toDto);
    }

    @GetMapping("noPagination")
    public List<UserResponseDto> getAllUsersNoPagination(Pageable pageable){

        List<User> user = userService.getAllUsersNoPagination(pageable);
        return userMapper.toDtoList(user);
    }

}
