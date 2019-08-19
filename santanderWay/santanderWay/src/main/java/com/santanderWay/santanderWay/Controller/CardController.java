package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.CartaoRepository;
import com.santanderWay.santanderWay.Model.Cartao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("session")
public class CardController {

    @Autowired
    private CartaoRepository cartaoRepository;

    @RequestMapping(value="/addCard", method = RequestMethod.GET)
    public String addCard()
    {
        return "view/cartao";
    }

    @RequestMapping(value="/addCard", method = RequestMethod.POST)
    public String addCard(@ModelAttribute("Cartao") Cartao cartao)
    {
        this.cartaoRepository.save(cartao);

        return "redirect:/addCard";
    }
}
