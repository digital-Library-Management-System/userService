package com.User.Service.services;


import com.User.Service.entities.Users;
import com.User.Service.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl {

    private final UsersRepository usersRepository;

    public Users addUsers(Users users){
      boolean usersEmail =  usersRepository.findByEmail(users.getEmail()).isPresent();
      boolean userName = usersRepository.findByName(users.getName()).isPresent();

      if(usersEmail || userName){
          throw new IllegalArgumentException("user already exists");
      }


       return usersRepository.save(users);
    }
}
