/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.thinh.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.thinh.pojos.User;
import com.thinh.repositories.Impl.UserRepositoryImpl;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.thinh.repositories.UserRepository;
import com.thinh.servicies.UserService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Ngoc Thinh
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private Cloudinary cloudinary;
    
    // GET LIST
    @GetMapping("/")
    public String index() {
        
        return "baseLayout";
    }
    //
    
    @GetMapping("/login")
    public String login(Model model) {
        User user = new User();
        user.setIdUser(-1);
        model.addAttribute("user", user);
        
        model.addAttribute("test", "Test");
        
        return "login";
    }
    
    @PostMapping("/login")
    public String checkLogin(Model model, @ModelAttribute(value = "user") User user, HttpServletRequest request) {

        ServletContext servletContext = request.getServletContext();
        
        try {
            User foundUser = this.userService.getUserByUsername(user.getUsernameUser());
            
            if (foundUser != null)
            {
                if (foundUser.getPasswordUser().equals(user.getPasswordUser()))
                {
                    servletContext.setAttribute("fullname", foundUser.getFullNameUser());
                    
                    if (foundUser.getRoleUser().equals("ADMIN"))
                    {
                        servletContext.setAttribute("role", "ADMIN");
                        
                        return "homepageAdmin";
                    }
                    else if (foundUser.getRoleUser().equals("EMPLOYEE"))
                    {
                        servletContext.setAttribute("role", "EMPLOYEE");
                        
                        return "homepageEmployee";
                    }
                }
            }
            
            return "login";
        } catch (Exception ex) {
            return "login";
        }
    }
    
    @GetMapping("/homepageAdmin")
    public String homepageAdmin(Model model) {
        
        return "homepageAdmin";
    }
    
    @GetMapping("/homepageEmployee")
    public String homepageEmployee(Model model) {
        
        return "homepageEmployee";
    }
    
//    
//    // ADD or UPDATE
//    @GetMapping("/user")
//    public String showAdd(Model model) {
//        User user = new User();
//        user.setIdUser(-1);
//
//        model.addAttribute("user", user);
//
//        return "user";
//    }
//
//    @GetMapping("/user/{id}")
//    public String showUpdate(Model model, @PathVariable(value = "id") int id) {
//
//        User user = this.userRepository.getUserById(id);
//        model.addAttribute("user", user);
//
//        return "user";
//    }
//
//    @PostMapping("/user")
//    public String addOrUpdate(@ModelAttribute(value = "user") User user) {
//        
//        try {
//            Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//
//            String img = r.get("secure_url").toString();
////            String img = "111";
//
//            user.setAvatarUser(img);
//            
//            if (this.userService.addOrUpdateUser(user)) {
//                
//                return "redirect:/";
//            }
//            
//            return "user";
//        } catch (Exception ex) {
//            return "user";
//        }
//    }
//    //
//    
//    @RequestMapping("/name")
//    public String index2(Model model) {
//        
//        
//        User u = this.userService.getUserByUsername("123a");
//
//        model.addAttribute("users", u);
//        
//        return "content";
//    }
//    
//    @RequestMapping("/count")
//    public String countUser(Model model)
//    {
//        model.addAttribute("users", this.userService.countUser());
//        
//        return "content";
//    }
//    
//    // ADD
//    @GetMapping("/addUser")
//    public String showInputToAddUser()
//    {
//        return "addUser";
//    }
//    
//    @PostMapping("/addUser")
//    public String addUser(@ModelAttribute(value = "user") User u, Model model) {
//
//        this.userService.addUser(u);
//        
//        return "redirect:/";
//    }
//    //
//    
//    @GetMapping("/delete/{id}")
//    public String inputUserDelete(@PathVariable(value = "id") String id, Model model)
//    {
//        String msg = "non";
//        
//        if (id != null) 
//        {
//            this.userService.deleteUser(Integer.parseInt(id));
//            msg = "Xoa thanh cong";
//        }
//        else 
//        {
//            msg = "Khong co id";
//        }
//        
//        return "deleteUser";
//    }
//    
//    @GetMapping("/test")
//    public String test(@RequestParam Map<String, String> params,
//            Model model)
//    {
//        String id = params.get("id");
//        boolean check = false;
//        String msg = "non";
//        
//        if (id != null)
//        {
//            this.userRepository.deleteUser(Integer.parseInt(id));
//            
//            if (check) {
//                msg = "Xoa thanh cong";
//            } else {
//                msg = "Co id nhung khong tim thay de xoa";
//            }
//        }
//        else {
//            msg = "Khong co id";
//        }
//        
//        model.addAttribute("result", msg);
//        
//        return "redirect:/";
//    }
//    
//    @GetMapping("/update/{id}")
//    public String showToUpdate(Model model, @PathVariable(value = "id") int id)
//    {
//        model.addAttribute("user", this.userRepository.getUserById(id));
//        
//        return "updateUser";
//    }
//    
//    @PostMapping("/update/{id}")
//    public String updateUser(@ModelAttribute(value = "user") User u,
//            @PathVariable(value = "id") int id) {
//
//        User userq = this.userService.getUserById(id);
//        
////        userq.setUsername(u.getUsername());
//        
//        this.userService.updateUser(userq, id);
//
//        return "redirect:/";
//    }
//    
//    
}
