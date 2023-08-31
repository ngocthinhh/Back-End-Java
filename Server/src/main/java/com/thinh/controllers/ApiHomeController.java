/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.thinh.pojo.User;
import java.util.ArrayList;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.thinh.repositories.UsersRepository;
import com.thinh.servicies.UsersService;

/**
 *
 * @author Ngoc Thinh
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ApiHomeController {
    @Autowired
    private UsersRepository userRepository;
    
    @Autowired
    private UsersService userService;
    
    @GetMapping("/data")
    public String testApi()
    {
        return "API from NetBean";
    }
    
    @GetMapping("/dataUser")
    public List<User> testUser()
    {
        List<User> users = new ArrayList<>();
        
        User user = new User();
        user.setUsername("thinh");
        user.setPassword("123");
        
        User user2 = new User();
        user2.setUsername("duc");
        user2.setPassword("456");
        
        users.add(user);
        users.add(user2);
        
        return users;
    }
    
    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUser()
    {
        return new ResponseEntity<>(this.userService.getUser(), HttpStatus.OK);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserByID(@PathVariable int id) {
        User user = this.userService.getUserById(id);

        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/user/add")
    public ResponseEntity<List<User>> addUser(@RequestBody User newUser) {
        User user = new User();
        user = newUser;
        user.setId(-1);
        this.userService.addOrUpdateUser(user);
        return new ResponseEntity<>(this.userService.getUser(), HttpStatus.CREATED);
    }
    
    @PutMapping("/user/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updateUser) {
        
        User user = this.userService.getUserById(id);
        if (user != null)
        {
//            user = updateUser;
            // PHẢI THAM CHIẾU NHƯ VẬY
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());
            
            if (this.userService.addOrUpdateUser(user)) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        this.userService.deleteUser(id);
        
        return new ResponseEntity<>("Xoá thành công!",HttpStatus.OK);
    }
}
