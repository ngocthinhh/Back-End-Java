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
public interface UsersRepository {
    List<User> getUser();
    User getUserByUsername(String username);
    boolean isHaveUserByUsername(String username);
    int countUser();
    boolean addUser(User user);
    void deleteUser(int id);
    User getUserById(int id);
    void updateUser(User user, int id);
    boolean addOrUpdateUser(User user);
}
