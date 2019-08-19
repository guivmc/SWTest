package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.Model.Saldo;
import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.SaldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SaldoController {

    @Autowired
    private SaldoRepository saldoRepository;

    @RequestMapping(value="/addSaldo", method = RequestMethod.GET)
    public String addSaldo()
    {
        return "view/saldo";
    }

    @RequestMapping(value="/addSaldo", method = RequestMethod.POST)
    public String addSaldo(@ModelAttribute("Saldo") Saldo saldo)
    {
        this.saldoRepository.save(saldo);

        return "redirect:/addSaldo";
    }


}
