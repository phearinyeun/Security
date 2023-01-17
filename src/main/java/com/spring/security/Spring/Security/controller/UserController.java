package com.spring.security.Spring.Security.controller;

import com.spring.security.Spring.Security.model.User;
import com.spring.security.Spring.Security.service.UserServiceImpl;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.hibernate.cfg.AvailableSettings.USER;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public User create(@RequestBody @Validated User user){
        return userService.create(user);
    }

    @GetMapping
    public List<User> getAlluser(User user){
        return userService.getAllUser(user);
    }

    @GetMapping("/findid/{id}")
    public Optional<User> findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Long id){
        userService.deleteById(id);
            return null;
    }

    @GetMapping("/update/{id}")
    public User udpate(@RequestBody User user, @PathVariable("id") Long id){
        return userService.update(user, id);
    }
}
