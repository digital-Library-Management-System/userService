package com.User.Service.repositories;

import com.User.Service.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    boolean existsByEmailOrName(String email, String name);
    Page<User> findAll(Pageable pageable);



}
