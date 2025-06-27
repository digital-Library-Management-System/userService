package com.User.Service.services;


import com.User.Service.entities.Users;
import com.User.Service.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public Users addUsers(Users users){

      boolean isEmailExist =  usersRepository.findByEmail(users.getEmail()).isPresent();
      boolean isNameExist = usersRepository.findByName(users.getName()).isPresent();

      if(isEmailExist || isNameExist){
          throw new IllegalArgumentException("user already exists");
      }

       return usersRepository.save(users);
    }

    public Users getById(String id){

        return usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException( "user with id " + id + " does not exist"));
    }

    public List<Users> getAll(int page, int size){

        List<Users> listOfUsers = usersRepository.findAll(PageRequest.of(page - 1, size)).getContent();

        if(listOfUsers.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No users found");
        if (page < 1 || page > 2) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "the page must be between 1 and 2");
        else if (size > 6) throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "the size must be between 1 and 6");

        return listOfUsers;
    }
}
