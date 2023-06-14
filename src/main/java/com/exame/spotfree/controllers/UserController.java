package com.exame.spotfree.controllers;

import com.exame.spotfree.models.User;
import com.exame.spotfree.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    private final UserServiceImpl userService;

    @GetMapping("/")
    public List<User> getAll(){
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id){
        return userService.getOne(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user){
        return userService.update(user);
    }

    @PostMapping("/deactivate/{id}")
    public void deactivate(@PathVariable Long id){
        userService.deactivate(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }

}
