package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/Revisao")
public class RevisaoControle {
    final Map<Integer, String> titulo = new HashMap<Integer, String>() {
        {
            put(0, "Selecione 1 das opções");
            put(1, "Ciencias Humanas");
            put(2, "Ciencias Exatas");
            put(3, "Ciencias Biologicas");
            put(4, "Egenharias");
            put(5, "Ciencias Sociais");
        }

    };
    @Autowired
    private TrabalhoRepositorio trabRepositorio;

    @RequestMapping("/revisar.html")
    public ModelAndView revisar(long id) {
        ModelAndView mv = new ModelAndView();
        List<Trabalho> trabalhos = trabRepositorio.findAll();
        mv.setViewName("trabalho-form");
        mv.addObject("id", id);
        
        Trabalho aux = new Trabalho("Titulo", "Descrição textual", "Link para o site", new AreaDeConhecimento());
        aux.getAreaConhecimento().setTitulo(0);
        mv.addObject("novoTrabalho",aux);
        mv.addObject("trabalhos", trabalhos);
        mv.addObject("opcoes", titulo.entrySet());
        return mv;
    }

    @PostMapping("/trabalho-form.html")
    public ModelAndView criar(long id, @Valid Trabalho novoTrabalho, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        trabRepositorio.save(novoTrabalho);
        Trabalho aux = new Trabalho("Titulo", "Descrição textual", "Link para o site", new AreaDeConhecimento());
        aux.getAreaConhecimento().setTitulo(0);
        mv.addObject("novoTrabalho",aux);
        List<Trabalho> trabalhos = trabRepositorio.findAll();
        mv.setViewName("trabalho-form");
        mv.addObject("id", id);
        mv.addObject("trabalhos", trabalhos);
        mv.addObject("opcoes", titulo.entrySet());
        return mv;

    }

}