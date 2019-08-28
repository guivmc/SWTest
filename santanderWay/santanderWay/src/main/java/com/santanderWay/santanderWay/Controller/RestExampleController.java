package com.santanderWay.santanderWay.Controller;


import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/server/rest")
public class RestExampleController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list")
    public  Iterable<User> list()
    {
        return this.userRepository.findAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody User user)
    {
        this.userRepository.save(user);
    }

    @GetMapping("/find/{id}")
    public User get(@PathVariable("id") long id)
    {
        return this.userRepository.findById(id);
    }
}
