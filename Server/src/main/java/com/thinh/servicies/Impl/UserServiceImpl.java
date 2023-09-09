/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.servicies.Impl;

import com.thinh.pojos.User;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.thinh.repositories.UserRepository;
import com.thinh.servicies.UserService;

/**
 *
 * @author Ngoc Thinh
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getUser() {
        return this.userRepository.getUser();
    }
    
    @Override
    public List<User> getUsersByRole(String role) {
        return this.userRepository.getUsersByRole(role);
    }
    
    @Override
    public User getUserByUsername(String username)
    {
        return this.userRepository.getUserByUsername(username);
    }
    
    @Override
    public User getUserById(int id) {
        return this.userRepository.getUserById(id);
    }
    
    @Override
    public boolean isHaveUserByUsername(String username) {
        return this.userRepository.isHaveUserByUsername(username);
    }
    
    @Override
    public int countUser() {
        return this.userRepository.countUser();
    }
    
    @Override
    public boolean addUser(User user)
    {
        return this.userRepository.addUser(user);
    }
    
    @Override
    public void deleteUser(int id)
    {
        this.userRepository.deleteUser(id);
    }
    
    @Override
    public void updateUser(User user, int id) {
        this.userRepository.updateUser(user, id);
    }
    
    @Override
    public boolean addOrUpdateUser(User user) {
        return this.userRepository.addOrUpdateUser(user);
    }

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
