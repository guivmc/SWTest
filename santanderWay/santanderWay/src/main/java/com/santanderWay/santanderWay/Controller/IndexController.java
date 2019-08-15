package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController
{

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
}
