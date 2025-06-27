package com.User.Service.repositories;

import com.User.Service.entities.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, ObjectId> {

    Optional<Users>  findByEmail(String email);
    Optional<Users> findByName(String name);



}
