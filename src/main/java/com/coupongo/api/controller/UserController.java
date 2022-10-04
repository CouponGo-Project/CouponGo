package com.coupongo.api.controller;

import com.coupongo.business.abstracts.UserService;
import com.coupongo.core.utilities.results.DataResult;
import com.coupongo.core.utilities.results.Result;
import com.coupongo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public DataResult<List<User>> getAll() {
        return this.userService.getAll();

    }


    @PostMapping(value = "/add",  produces  = "application/json",consumes  = "application/json")
    public Result addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }


    @DeleteMapping
    public DataResult<User> deleteUser(int userId) {
        return this.userService.deleteUser(userId);
    }
}