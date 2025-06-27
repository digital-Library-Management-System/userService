package com.User.Service.services;

import com.User.Service.entities.Users;

import java.util.List;


public interface UsersService {

     Users addUsers(Users users);

     Users getById(String id);

     List<Users> getAll(int page, int size);
}
