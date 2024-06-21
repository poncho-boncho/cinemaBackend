package com.poncho_boncho.cinema.controllers;

import com.poncho_boncho.cinema.api.model.User;
import com.poncho_boncho.cinema.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService){
        this.userService = userService;
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("")
    public ResponseEntity<List<User>> user() {
        if (userService.getAll().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<User> add(@RequestBody User user){
        try {
            return new ResponseEntity<>(userService.addUser(user),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        //return staffService.addStaff(staff);
    }
}
