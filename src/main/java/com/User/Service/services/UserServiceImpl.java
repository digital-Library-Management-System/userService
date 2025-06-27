package com.User.Service.services;


import com.User.Service.entities.User;
import com.User.Service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;




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
}
