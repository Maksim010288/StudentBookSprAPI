package com.example.demo.model;

import com.example.demo.entity.UserEntity;
import lombok.Data;

@Data
public class UsersModel {
    private final String userName;
    private final String password;
    private final String email;

    public UsersModel(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public UsersModel getUsersModel(UserEntity userEntity){
        return new UsersModel(userEntity.getUsername(),
                String.valueOf(userEntity.getPassword()),
                userEntity.getEmail());
    }
}
