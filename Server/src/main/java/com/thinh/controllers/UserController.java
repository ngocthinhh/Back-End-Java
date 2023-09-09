/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thinh.pojos.User;
import com.thinh.servicies.UserService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Ngoc Thinh
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Cloudinary cloudinary;
    
    // GET LIST
    @GetMapping("/listUser")
    public String getAll(Model model) {
        model.addAttribute("users", this.userService.getUser());

        return "listUser";
    }
    //
    
    @GetMapping("/user")
    public String showAdd(Model model) {
        User user = new User();
        user.setIdUser(-1);

        model.addAttribute("user", user);

        return "user";
    }
    
    @GetMapping("/user/{id}")
    public String showUpdate(Model model, @PathVariable(value = "id") int id) {

        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);

        return "user";
    }
    
    @PostMapping("/user")
    public String addOrUpdate(Model model, @ModelAttribute(value = "user") User user) {
        
        try {
//            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//
//            String img = r.get("secure_url").toString();
            String img = "no-image";

            user.setAvatarUser(img);
            
            if (this.userService.addOrUpdateUser(user)) {
                model.addAttribute("users", this.userService.getUser());
                return "listUser";
            }
            
            return "user";
        } catch (Exception ex) {
            return "user";
        }
    }
    
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") String id, Model model)
    {
        String msg = "non";
        
        if (id != null) 
        {
            this.userService.deleteUser(Integer.parseInt(id));
            msg = "Xoa thanh cong";
        }
        else 
        {
            msg = "Khong co id";
        }
        
        model.addAttribute("users", this.userService.getUser());
        
        return "listUser";
    }
}
