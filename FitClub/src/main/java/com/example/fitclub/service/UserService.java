package com.example.fitclub.service;

import com.example.fitclub.model.MyUser;
import com.example.fitclub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    public List<MyUser> getUsers() {
        return userRepository.findAll();
    }

    public void addUser(MyUser user) {
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MyUser> myUserOptional = userRepository.findByUsername(username);
        if (myUserOptional.isPresent()) {
            MyUser myUser = myUserOptional.get();
            return User.builder()
                    .username(myUser.getUsername())
                    .password(myUser.getPassword())
                    .roles(myUser.getRole())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }
}