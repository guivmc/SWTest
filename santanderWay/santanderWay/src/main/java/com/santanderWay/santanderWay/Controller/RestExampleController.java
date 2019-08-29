package com.santanderWay.santanderWay.Controller;


import com.santanderWay.santanderWay.CartaoRepository;
import com.santanderWay.santanderWay.Model.Cartao;
import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/server/rest")
public class RestExampleController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/list")
    public  Iterable<User> list()
    {
        return this.userRepository.findAll();
    }

    @PostMapping("/add")
    //@ResponseStatus(HttpStatus.OK)
    public void create(@RequestBody User user,  HttpServletResponse response)
    {
        User exist = this.userRepository.findByIdentifierLike(user.getIdentifier());

        if(exist == null)
        {
            this.userRepository.save(user);
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
        }
        else
            response.setStatus(HttpServletResponse.SC_CONFLICT);
    }

    @GetMapping("/findUser/{id}")
    public User getUser(@PathVariable("id") long id)
    {
        return this.userRepository.findById(id);
    }

    @GetMapping("/findUserCards/{idUser}")
    public Iterable<Cartao> getUserCards(@PathVariable("idUser") long idUser)
    {
        return this.cartaoRepository.findCards(idUser);
    }

}
