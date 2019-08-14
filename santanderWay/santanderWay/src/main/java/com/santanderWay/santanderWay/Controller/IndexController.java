package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController
{

    //
    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("User") User user, BindingResult result)
    {

        System.out.println("Name:" + user.getName() +
                "Password:" + user.getPassword());

        return "redirect:index.html";
    }
}
