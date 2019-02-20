package ufc.quixada.autoestudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ufc.quixada.autoestudo.model.Contato;
import ufc.quixada.autoestudo.service.ContatoService;

import java.util.List;

@RestController
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @RequestMapping(path = "/")
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        List<Contato> contatos = contatoService.findAll();
        model.addObject("contatos", contatos);

        return model;
    }

    @RequestMapping(path = "/adicionarcontato", method=RequestMethod.POST)
    public String addContato(@RequestParam Contato contato) {
        contatoService.saveContact(contato);
        return "redirect:/index/";
    }
}
