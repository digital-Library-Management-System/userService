package com.User.Service.services;

import com.User.Service.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserService {

     User addUsers(User users);

     User getById(String id);

     Page<User> getAll(Pageable pageable);

     List<User> getAllUsers();
}