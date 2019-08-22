package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.CartaoRepository;
import com.santanderWay.santanderWay.Model.Cartao;
import com.santanderWay.santanderWay.Model.Saldo;
import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.SaldoRepository;
import com.santanderWay.santanderWay.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("session")
public class IndexController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    @Autowired
    private SaldoRepository saldoRepository;


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

         if (exist != null)
         {
             List<Cartao> cartao = this.cartaoRepository.findCards(exist.getId());
             List<Saldo> saldoTotal = new ArrayList<>();

             for (Cartao forCartao: cartao) {

                 List<Saldo> saldo = this.saldoRepository.findSaldos(forCartao.getId());

                 double total = 0;
                 long idCartao;

                 for (Saldo somaSaldo: saldo) {
                     total += somaSaldo.getValor();
                 }

                 saldoTotal.add(new Saldo(total, forCartao.getId()));
             }

             ModelAndView model = new ModelAndView("view/profile");
             model.addObject("user", exist);
             model.addObject("cartao", cartao);
             model.addObject("saldo", saldoTotal);

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
