package com.santanderWay.santanderWay.Controller;

import com.santanderWay.santanderWay.service.LoginFacebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.MalformedURLException;

@Controller
public class FaceBookController {

    @Autowired
    private LoginFacebook loginFacebook;

    /**
     * Método que chama URL do facebook onde o usuário poderá autorizar a aplicação
     * a acessar seus recursos privados.
     *
     * @return
     */
    @RequestMapping(value = "/loginfb", method = RequestMethod.GET)
    public String logarComFacebook() {
        return "redirect:" + loginFacebook.getLoginRedirectURL();
    }

    /**
     * Executado quando o Servidor de Autorização fizer o redirect.
     *
     * @param
     * @return
     * @throws MalformedURLException
     * @throws IOException
     */
    @RequestMapping(value = "/loginfbresponse", method = RequestMethod.GET)
    public String logarComFacebook(String code) throws MalformedURLException, IOException {

        loginFacebook.obterUsuarioFacebook(code);

        return "redirect:/Sucesso";
    }

    @RequestMapping(value = "/Sucesso", method = RequestMethod.GET)
    public ResponseEntity<?> chamarTela() {
          return ResponseEntity.ok("Sucesso");

    }

}
