/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thinh.servicies;

import com.thinh.pojo.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author Ngoc Thinh
 */
public interface UserService extends UserDetailsService{
    List<User> getUser();
    User getUserByUsername(String username);
    boolean isHaveUserByUsername(String username);
    int countUser();
    boolean addUser(User user);
    void deleteUser(int id);
    boolean updateUser(User user);
    boolean addOrUpdateUser(User user);
}
