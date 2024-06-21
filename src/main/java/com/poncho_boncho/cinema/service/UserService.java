package com.poncho_boncho.cinema.service;

import com.poncho_boncho.cinema.api.model.Staff;
import com.poncho_boncho.cinema.api.model.User;
import com.poncho_boncho.cinema.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    public Optional<User> getById(String id){
        return userRepository.findByUsername(id);
    }

    public User addUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

}
