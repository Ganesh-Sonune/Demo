package com.TechPulse.Demo.service;

import com.TechPulse.Demo.Entity.User;
import com.TechPulse.Demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User upDateUser(long id , User newData){
        User existingUser = userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));

        existingUser.setName(newData.getName());
        existingUser.setEmail(newData.getEmail());
        existingUser.setAge(newData.getAge());

        return userRepository.save(existingUser);
    }



    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deletUserbyId(long id){
       userRepository.deleteById(id);
    }
}

