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


@Controller
@RequestMapping("/area-de-conhecimento")
public class AreaDeConhecimentoControle {

    @Autowired
    private AvaliadorRepositorio avalRepositorio;
    @Autowired
    private AreaDeConhecimentoRepositorio areaRepositorio;
    
    @RequestMapping("/novaArea.html")
    public ModelAndView areaDeConhecimento(long id) {
        ModelAndView mv = new ModelAndView();
        List<AreaDeConhecimento> areas = areaRepositorio.findAll();
           //// findByIdAvaliador(avalRepositorio.getOne(id));
        mv.setViewName("area-de-conhecimento-form");
        mv.addObject("id", id);
        mv.addObject("novaArea", new AreaDeConhecimento("Titulo", "Descrição textual"));
        mv.addObject("areas", areas);
        return mv;
    }
    @PostMapping("/area-de-conhecimento-form.html")
    public ModelAndView criar(long id, @Valid AreaDeConhecimento novaArea,
        BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (!binding.hasErrors()) {
            mv.addObject("novaArea", new AreaDeConhecimento("Titulo", "Descrição textual"));    
        }else{
            mv.addObject("novaArea", novaArea);
        }
        novaArea.setIdAvaliador(avalRepositorio.getOne(id));
        areaRepositorio.save(novaArea);
        List<AreaDeConhecimento> areas = areaRepositorio.
            findByIdAvaliador(avalRepositorio.getOne(id));
        mv.setViewName("area-de-conhecimento-form");
        mv.addObject("id", id);
        mv.addObject("area", areas);
        
        return mv;

    }

    
}