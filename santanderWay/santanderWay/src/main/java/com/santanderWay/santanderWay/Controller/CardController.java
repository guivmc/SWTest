package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.CartaoRepository;
import com.santanderWay.santanderWay.Model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
public class CardController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @RequestMapping(value="/addCard", method = RequestMethod.GET)
    public String addCard(HttpSession session)
    {
        if(session.getAttribute("userId") == null)
            return "view/index";

        return "view/cartao";
    }

    @RequestMapping(value="/addCard", method = RequestMethod.POST)
    public String addCard(@ModelAttribute("Cartao") Cartao cartao, HttpSession session)
    {
        if(session.getAttribute("userId") == null)
            return "view/index";

        cartao.setIdUser( (long) session.getAttribute("userId") );

        cartao.setNome( (String) session.getAttribute("userName") );

        this.cartaoRepository.save(cartao);

        return "redirect:/addCard";
    }
}
