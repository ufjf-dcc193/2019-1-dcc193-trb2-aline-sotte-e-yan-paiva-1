package br.ufjf.dcc193.Trabalho_Aline_e_Yan;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * HomeController
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    @ResponseBody
    public String index(){
        return "<h1> Bem Vindo</h1>";
    }
    
}