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
@RequestMapping("/area-de-conhecimento")
public class AreaDeConhecimentoControle {
    final Map<Integer, String> titulo = new HashMap<Integer, String>(){{
        put(0,"Selecione 1 das opções");
        put(1,"Ciencias Humanas");
        put(2,"Ciencias Exatas");
        put(3,"Ciencias Biologicas");
        put(4,"Egenharias");
        put(5,"Ciencias Sociais");            }
        };

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
        mv.addObject("novaArea", new AreaDeConhecimento(0, "Descrição textual"));
        mv.addObject("areas", areas);
        mv.addObject("opcoes", titulo.entrySet());
        return mv;
    }
    @PostMapping("/area-de-conhecimento-form.html")
    public ModelAndView criar(long id, @Valid AreaDeConhecimento novaArea,
        BindingResult binding) {
        ModelAndView mv = new ModelAndView();
        if (!binding.hasErrors()) {
            mv.addObject("novaArea", new AreaDeConhecimento(0, "Descrição textual"));    
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
        mv.addObject("opcoes", titulo.entrySet());
        
        return mv;

    }

    
}