package com.custom.user.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/user")
    User newUser(@RequestBody User newUser)
    {
        return user_repo.save(newUser);
    }

    @GetMapping("/getAllUsers")
    List<User> getAllUsers()
    {
        return user_repo.findAll();
    }


    @PutMapping("/updateUser/{id}")
    User updateUser(@PathVariable int id,@RequestBody User body)
    {
        return user_repo.save(body);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable Long id)
    {
        user_repo.deleteById(id);
    }
}
