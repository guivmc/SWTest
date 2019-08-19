package com.santanderWay.santanderWay.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CardController {

    @RequestMapping(value="/addCard", method = RequestMethod.GET)
    public String addCard()
    {
        return "view/cartao";
    }
}
