package com.example.demo.library.users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    UsersRepository usersRepository;

    Iterable<UserDto> getAllUsers() {
        List<UserEntity> userEntities = new ArrayList<UserEntity>();
        this.usersRepository.findAll().forEach(userEntities::add);
        return this.convertUserEntitiesToUserDtos(userEntities);
    }

    Iterable<UserDto> convertUserEntitiesToUserDtos (List<UserEntity> userEntities) {
        List<UserDto> userDtos = new ArrayList<UserDto>();
        for (UserEntity ue : userEntities) {
            userDtos.add(UserDto.builder()
                    .email(ue.getEmail())
                    .firstName(ue.getFirstName())
                    .lastName(ue.getLastName())
                    .age(ue.getAge())
                    .dniStr(ue.getDniStr())
                    .build());
        }
        return userDtos;
    }

    UserDto createUser(UserDto user) {
        System.out.println("user: " + user);
        UserEntity userEntity = UserEntity.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .age(user.getAge())
                .dniStr(user.getDniStr())
                .build();
        this.usersRepository.save(userEntity);
        return user;
    }
    
}
