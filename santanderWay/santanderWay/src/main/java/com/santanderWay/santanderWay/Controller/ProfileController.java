package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.CartaoRepository;
import com.santanderWay.santanderWay.Model.Cartao;
import com.santanderWay.santanderWay.Model.User;
import com.santanderWay.santanderWay.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Scope("session")
public class ProfileController
{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartaoRepository cartaoRepository;


    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView home(HttpSession session)
    {
        if(session.getAttribute("userId") == null)
            return new ModelAndView("view/index");

        User exist = this.userRepository.findById((long) session.getAttribute("userId"));
        //Cartao cartao = this.cartaoRepository.findByIdUser(exist.getId());

        if (exist != null)
        {
            List<Cartao> cartao = this.cartaoRepository.findCards(exist.getId());

            ModelAndView model = new ModelAndView("view/profile");
            model.addObject("user", exist);
            model.addObject("cartao", cartao);

            return model;
        }

        return new ModelAndView("view/index");
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session)
    {
        session.invalidate();

        return "view/index";
    }
}
