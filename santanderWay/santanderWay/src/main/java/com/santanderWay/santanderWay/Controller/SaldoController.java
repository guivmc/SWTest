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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SaldoController
{

    @Autowired
    private SaldoRepository saldoRepository;


    @RequestMapping(value="/addSaldo", method = RequestMethod.POST)
    public String addSaldo(@ModelAttribute("Saldo") Saldo saldo, HttpSession session)
    {
        if(session.getAttribute("userId") == null)
            return "view/index";

        saldo.setIdCartao((long) session.getAttribute("cardId"));

        session.removeAttribute("cardId");

        this.saldoRepository.save(saldo);

        return "redirect:/home";
    }

    @RequestMapping("/addSaldo?idCard={idCard}")
    public String showSaldos(@PathVariable("idCard") long idCard, HttpServletRequest request)
    {
        System.out.println(idCard);

        request.getSession().setAttribute("cardId", idCard);

        return "view/saldo";
    }


}
