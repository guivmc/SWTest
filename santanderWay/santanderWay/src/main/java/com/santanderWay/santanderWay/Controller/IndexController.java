package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController
{
    @Autowired
    private UserRepository userRepository;


    @RequestMapping("/")
    public String index()
    {
        return "view/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("User") User user, BindingResult result)
    {

        System.out.println("Name:" + user.getId() +
                "Password:" + user.getPassword());

        return "view/index";
    }

    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public String addUser()
    {
        return "view/user";
    }

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("User") User user)
    {
        this.userRepository.save(user);

        return "redirect:/addUser";
    }
}
