package com.TechPulse.Demo.Controller;


import com.TechPulse.Demo.Entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/notifyUsers")
public class NotificationController {

    private Map<Long , User> userDatabase = new HashMap<>();

    @GetMapping
   public List<User> getAllUsers(){
       return new ArrayList<>(userDatabase.values());
   }

   @PostMapping
    public String addUser(@RequestBody User user){
       userDatabase.put(user.getId(), user);
       return "User added successfully";
   }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable long id) {
        User user = userDatabase.get(id);

        if (user == null) {
            throw new RuntimeException("User not found with id: " + id);
        }

        return user;
    }


    @DeleteMapping("id/{id}")
    public String deleteById(@PathVariable long id){
       return "User deleted :" + userDatabase.remove(id).toString();
    }

    @PutMapping("/id/{id}")
    public String updateUser(@RequestBody User user , @PathVariable long id){
       userDatabase.put(id , user);
       return "User updated successfully";
    }

    @PatchMapping("/id/{id}")
    public String updateUserSpecific(@RequestBody User user , @PathVariable long id){
        userDatabase.put(id , user);
        return "User updated successfully";
    }
}
