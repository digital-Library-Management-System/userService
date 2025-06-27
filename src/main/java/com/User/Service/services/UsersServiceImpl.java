package com.User.Service.services;


import com.User.Service.entities.Users;
import com.User.Service.repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;



@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public Users addUsers(Users users){

      boolean usersEmail =  usersRepository.findByEmail(users.getEmail()).isPresent();
      boolean userName = usersRepository.findByName(users.getName()).isPresent();

      if(usersEmail || userName){
          throw new IllegalArgumentException("user already exists");
      }

       return usersRepository.save(users);
    }

    public Users getById(ObjectId id){

        return usersRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException( "user with id " + id + " does not exist"));

    }
}
