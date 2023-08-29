/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.thinh.repositories;

import com.thinh.pojo.User;
import java.util.List;

/**
 *
 * @author Ngoc Thinh
 */
public interface UserRepository {
    List<User> getUser();
    User getUserByUsername(String username);
    boolean isHaveUserByUsername(String username);
    int countUser();
    boolean addUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    boolean updateUser(User user);
    boolean addOrUpdateUser(User user);
    boolean updateUser(User user, String usernam);
}
