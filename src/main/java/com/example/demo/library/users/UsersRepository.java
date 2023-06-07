package com.example.demo.library.users;

import java.util.List;

public interface UsersRepository extends org.springframework.data.repository.CrudRepository<UserEntity, Long>{
    UserEntity findById(long id);
    UserEntity findByEmail(String email);
    List<UserEntity> findByFirstName(String firstName);
    List<UserEntity> findByLastName(String lastName);
}