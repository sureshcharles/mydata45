package com.example.mydata45.controller;
import com.example.mydata45.model.User;
import com.example.mydata45.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Apicontroller {
    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/users")

    public List<User> getUsers()
    {
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")

    public String saveUser(@RequestBody User user)
    {
        userRepo.save(user);
        return "saved...";
    }
    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id,  @RequestBody User user)
    {
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstname(user.getFirstname());
        updatedUser.setLastname(user.getLastname());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);
        return "updated";
    }
    @DeleteMapping(value = "delete/{id}")
    public String deleteUser(@PathVariable long id )
    {
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return " deleted user with id: " +id;
    }



}
