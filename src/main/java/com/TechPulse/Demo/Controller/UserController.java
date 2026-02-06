package com.TechPulse.Demo.Controller;

import com.TechPulse.Demo.Entity.User;
import com.TechPulse.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String CreateUser(@RequestBody User user){
        userService.saveUser(user);
        return "User created successfully";
    }

    @PutMapping("/id/{id}")
    public String upDateUser(@RequestBody User user , @PathVariable long id){
        userService.upDateUser(id , user);
        return "User updated successfully";
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping
    public String deleteUserById(@RequestParam long id){
        userService.deletUserbyId(id);
        return "User deleted successfully";
    }
}
