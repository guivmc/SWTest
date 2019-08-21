package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.Model.Saldo;
import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class SaldoController
{

    @Autowired
    private SaldoRepository saldoRepository;

    @RequestMapping(value="/addSaldo", method = RequestMethod.GET)
    public String addSaldo(HttpSession session)
    {
        if(session.getAttribute("userId") == null)
            return "view/index";

        return "view/saldo";
    }

    @RequestMapping(value="/addSaldo", method = RequestMethod.POST)
    public String addSaldo(@ModelAttribute("Saldo") Saldo saldo, HttpSession session)
    {
        if(session.getAttribute("userId") == null)
            return "view/index";

        this.saldoRepository.save(saldo);

        return "redirect:/addSaldo";
    }

    @RequestMapping("/{idCard}")
    public ModelAndView showSaldos(@PathVariable("idCard") long idCard)
    {
        System.out.println(idCard);

        return new ModelAndView("view/index");
    }


}
