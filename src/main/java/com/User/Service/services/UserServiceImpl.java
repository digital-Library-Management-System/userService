package com.User.Service.services;


import com.User.Service.BookClient;
import com.User.Service.dto.BookResponseDto;
import com.User.Service.entities.User;
import com.User.Service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository usersRepository;

    public User addUsers(User users){

        boolean isEmailOrNameExist  = usersRepository.existsByEmailOrName(users.getEmail(), users.getName());

        if(isEmailOrNameExist){
            throw new IllegalArgumentException("user already exists");
        }

        return usersRepository.save(users);
    }

    public User getById(String id){

        return usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException( "user with id " + id + " does not exist"));
    }

    public List<User> getAll(int page, int size){

        List<User> listOfUsers = usersRepository.findAll(PageRequest.of(page - 1, size)).getContent();

        if (page < 1 || page > 2) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "the page must be between 1 and 2");
        else if (size > 6) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "the size must be between 1 and 6");

        return listOfUsers;
    }

}
