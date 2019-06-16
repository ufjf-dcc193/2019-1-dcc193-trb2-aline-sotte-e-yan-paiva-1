package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * AvaliadorControle
 */

@Controller
@RequestMapping("/avaliador")
public class AvaliadorControle {

    @Autowired
    private AvaliadorRepositorio avalRepositorio;

    @RequestMapping({ "/", "/index.html" })
    public String index() {
        return "avaliador";
    }

    @GetMapping("/nova.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliador-form");
        mv.addObject("avaliador", new Avaliador("nome", "email"));

        return mv;
    }

    @PostMapping("/nova.html")
    public ModelAndView criar(@Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {

            mv.setViewName("redirect:listar.html");
            avalRepositorio.save(avaliador);
            mv.addObject("avaliador", avaliador);
            return mv;
        }

        avalRepositorio.save(avaliador);
        mv.setViewName("redirect:listar.html");
        return mv;

    }

    @GetMapping("/listar.html")
    public ModelAndView listar() {
        List<Avaliador> aval = avalRepositorio.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("avaliador-listar");
        mv.addObject("avaliador", aval);
        return mv;
    }

    @GetMapping("/editar/{id}")
    @PostMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, @Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("avaliador-form-edit");
            mv.addObject("atividade", avaliador);
            return mv;
        }
        avalRepositorio.save(avaliador);
        mv.setViewName("redirect:../listar.html");
        return mv;
    }
 



}