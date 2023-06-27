package com.custom.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.custom.user.Repository.UserRepo;
import com.custom.user.Model.User;

@RestController
public class UserController {
    @Autowired
    private UserRepo user_repo;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/user")
    User newUser(@RequestBody User newUser)
    {
        return user_repo.save(newUser);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllUsers")
    List<User> getAllUsers()
    {
        return user_repo.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/updateUser/{id}")
    User updateUser(@PathVariable int id,@RequestBody User body)
    {
        return user_repo.save(body);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable Long id)
    {
        user_repo.deleteById(id);
    }
}
