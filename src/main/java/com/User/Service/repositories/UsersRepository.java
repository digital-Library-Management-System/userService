package com.User.Service.repositories;

import com.User.Service.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, String> {

    Optional<Users>  findByEmail(String email);
    Optional<Users> findByName(String name);
    Page<Users> findAll(Pageable pageable);



}
