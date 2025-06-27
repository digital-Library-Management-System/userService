package com.User.Service.controllers;

import com.User.Service.dto.UsersRequestDto;
import com.User.Service.dto.UsersResponseDto;
import com.User.Service.entities.Users;
import com.User.Service.mappers.UsersMapper;

import com.User.Service.services.UsersServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="userService")
@RequiredArgsConstructor
public class UserController {

    private final UsersServiceImpl usersServiceImpl;
    private final UsersMapper usersMapper;


    @PostMapping
    public ResponseEntity<UsersResponseDto> createBook(@RequestBody UsersRequestDto usersRequestDto){

        Users users = usersMapper.toEntity(usersRequestDto);
        UsersResponseDto  response = usersMapper.toDto(usersServiceImpl.addUsers(users));

        return ResponseEntity.ok(response);

    }

    @GetMapping(path="{id}")
    public ResponseEntity<UsersResponseDto> getUsersById(@PathVariable String id){

        Users users = usersServiceImpl.getById(id);
        UsersResponseDto responseDto = usersMapper.toDto(users);

        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<UsersResponseDto>> getAllUsers(@RequestParam int page, @RequestParam int size){

        List<Users> usersList = usersServiceImpl.getAll(page,size);
        List<UsersResponseDto> responseDto = usersMapper.toDtoList(usersList);

        return ResponseEntity.ok(responseDto);
    }

}
