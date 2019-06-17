package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * HomeController
 */
@Controller
public class HomeController {
    @Autowired
    AvaliadorRepositorio avdRepo;
    @RequestMapping("/")
    @ResponseBody
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @PostMapping(value="/login.html")
    public ModelAndView login(String email, String senha){
            ModelAndView mv = new ModelAndView();
            
            Avaliador avaliador = avdRepo.getOne(
                avdRepo.getIdByEmailAndSenha(email, senha)); 
            mv.setViewName("redirect:listar.html");
            return mv;
    }
    
}