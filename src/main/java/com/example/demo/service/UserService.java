package com.example.demo.service;

import com.example.demo.entity.RolesEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.model.UsersModel;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity usersEntity = userRepository.findByUsername(username);
        if (usersEntity == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", username));
        }
        return new User(
                usersEntity.getUsername(),
                String.valueOf(usersEntity.getPassword()),
                mapRolesAuthorities(usersEntity.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesAuthorities(Collection<RolesEntity> rolesEntities) {
        return rolesEntities.stream()
                .map(r -> new SimpleGrantedAuthority(r.getName()))
                .collect(Collectors.toList());
    }

    public void create(UserEntity user) {
        userRepository.save(user);
    }

    public List<UsersModel> getUsersAndUsersRole() {
        return userRepository.findAll().stream()
                .map(user -> new UsersModel(user.getUsername(),
                        String.valueOf(user.getPassword()), user.getEmail()))
                .collect(Collectors.toList());
    }
}
