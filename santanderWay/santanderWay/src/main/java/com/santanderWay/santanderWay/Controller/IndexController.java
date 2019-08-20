package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.CartaoRepository;
import com.santanderWay.santanderWay.Model.Cartao;
import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.management.modelmbean.RequiredModelMBean;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@Scope("session")
public class IndexController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartaoRepository cartaoRepository;


    @RequestMapping("/")
    public String index()
    {
        return "view/index";
    }

     @RequestMapping(value = "/login", method = RequestMethod.POST)
     public ModelAndView login(@ModelAttribute("User") User user, HttpServletRequest request)
     {
         User exist = this.userRepository.findByIdentifierLikeAndPasswordLike(user.getIdentifier(), user.getPassword());
         //Cartao cartao = this.cartaoRepository.findByIdUser(exist.getId());

         List<Cartao> cartao = this.cartaoRepository.findCards(exist.getId());

         if (exist != null)
         {
             ModelAndView model = new ModelAndView("view/profile");
             model.addObject("user", exist);
             model.addObject("cartao", cartao);

             request.getSession().setAttribute("userId",  exist.getId());
             request.getSession().setAttribute("userName",  exist.getName());

             return model;
         }

         return new ModelAndView("view/index");
     }

//    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
//    public String sessionTest(HttpSession session)
//    {
//        System.out.println(session.getAttribute("test"));
//
//
//
//        return "view/index";
//    }

    @RequestMapping(value="/addUser", method = RequestMethod.GET)
    public String addUser()
    {
        return "view/user";
    }

    @RequestMapping(value="/addUser", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("User") User user)
    {
        if( this.userRepository.findByIdentifierLike(user.getIdentifier()) == null)
            this.userRepository.save(user);

        return "redirect:/addUser";
    }

}
