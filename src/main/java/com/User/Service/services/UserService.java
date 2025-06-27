package com.User.Service.services;

import com.User.Service.entities.User;

import java.util.List;


public interface UserService {

     User addUsers(User users);

     User getById(String id);

     List<User> getAll(int page, int size);
}
