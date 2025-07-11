package com.User.Service.services;



import com.User.Service.dto.BookResponseDto;
import com.User.Service.entities.User;
import com.User.Service.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


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

    public Page<User> getAll(Pageable pageable){

        return usersRepository.findAll(pageable);
    }

    public List<User> getAllUsers(){
        return usersRepository.findAll();
    }

}