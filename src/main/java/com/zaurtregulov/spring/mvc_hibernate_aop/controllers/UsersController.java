package com.zaurtregulov.spring.mvc_hibernate_aop.controllers;

import com.zaurtregulov.spring.mvc_hibernate_aop.model.User;
import com.zaurtregulov.spring.mvc_hibernate_aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "/all-users";
    }

    @GetMapping("/{id}")
    public String showById(@PathVariable("id") long id, Model model){

        model.addAttribute("user", userService.getUserById(id));
        return "/show";
    }


    @GetMapping("/new")
    public String addNewUser(Model model){
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") long id){

        userService.updateUser(user, id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/";
    }

//    @GetMapping("/remove/{id}")
//    public String removeUser(@PathVariable("id") long id){
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
//
//
//
//    @GetMapping("/userdata/{id}")
//    public String showUserById(@PathVariable("id") long id, Model model){
//        model.addAttribute("user", userService.getUserById(id));
//        return "/userdata";
//    }
//
//
//    @PostMapping("/saveUser")
//    public String saveUser(@ModelAttribute("user") User user){
//        userService.saveUser(user);
//        return "redirect:/";
//    }
//
//    @GetMapping("/updateInfo")
//    public String updateUser(@RequestParam("usId") Long id, Model model){
//        User user = userService.getUserById(id);
//        model.addAttribute("user", user);
//        return "user-info";
//    }
//
//    @GetMapping("/deleteUser")
//    public String deleteUser(@RequestParam("usId") int id){
//        userService.deleteUser(id);
//        return "redirect:/";
//    }
}
