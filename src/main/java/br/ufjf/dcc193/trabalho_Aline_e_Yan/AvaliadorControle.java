package br.ufjf.dcc193.trabalho_Aline_e_Yan;

import java.util.List;
import java.util.Random;

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
    @Autowired
    private AreaDeConhecimentoRepositorio areaRepositorio;

    @RequestMapping({ "/", "/index.html" })
    public String index() {
        return "avaliador";
    }
    
    @GetMapping("/novoavaliador.html")
    public ModelAndView criar() {
        ModelAndView mv = new ModelAndView();
        String codigoAcesso = String.valueOf(Long.toHexString(new Random().nextLong()));
        mv.setViewName("avaliador-form");
        mv.addObject("avaliador", new Avaliador("nome", "email", codigoAcesso));
        return mv;
    }

    @PostMapping("/novoavaliador.html")
    public ModelAndView criar(@Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {

            mv.setViewName("avaliador-form");
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
        mv.addObject("avaliadores", aval);
        return mv;
    }

    @GetMapping("/editar.html")
    public ModelAndView editar(@PathVariable Long id) {
        ModelAndView mv = new ModelAndView();
        Avaliador aval = avalRepositorio.getOne(id);
        mv.setViewName("avaliador-form-edit");
        mv.addObject("avaliador", aval);
        return mv;
    }
    @PostMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable Long id, @Valid Avaliador avaliador, BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (binding.hasErrors()) {
            mv.setViewName("avaliador-form-edit");
            mv.addObject("atividade", avaliador);
            return mv;
        }
        avalRepositorio.save(avaliador);
        mv.addObject("usuario", avaliador);
        mv.setViewName("home.html");
        return mv;
    }
 



}