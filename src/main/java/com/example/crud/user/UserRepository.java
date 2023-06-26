package com.example.crud.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u FROM User u where u.gender=:gender")
    Iterable<User> filterByGender(@Param("gender") String gender);
}