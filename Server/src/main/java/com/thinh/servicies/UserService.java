/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojos.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Ngoc Thinh
 */
public interface UserService extends UserDetailsService{
    List<User> getUser();
    User getUserByUsername(String username);
    List<User> getUsersByRole(String role);
    boolean isHaveUserByUsername(String username);
    int countUser();
    boolean addUser(User user);
    void deleteUser(int id);
    void updateUser(User user, int id);
    boolean addOrUpdateUser(User user);
    User getUserById(int id);
}
