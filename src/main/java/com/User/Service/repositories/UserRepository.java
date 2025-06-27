package com.User.Service.repositories;

import com.User.Service.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmailOrName(String email, String name);

}
