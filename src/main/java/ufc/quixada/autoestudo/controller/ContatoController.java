package ufc.quixada.autoestudo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ufc.quixada.autoestudo.model.Contato;
import ufc.quixada.autoestudo.service.ContatoService;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping()
    public ModelAndView index() {
        ModelAndView model = new ModelAndView("index");
        List<Contato> contatos = contatoService.findAll();
        model.addObject("contatos", contatos);

        return model;
    }

    @PostMapping(path = "adicionarcontato")
    public ResponseEntity<Object> addContato(@RequestParam String nome, String email) {
        Contato contato = contatoService.saveContact(nome, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }

    @GetMapping(path = "buscar/{id}")
    public ModelAndView exibirDetalhes(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("alterar");
        Contato contato = contatoService.findById(id);
        if(contato.getId() != null){
            model.addObject("contato", contato);
            return model;
        }
        return index();
    }

    @PutMapping(path = "alterar/{id}")
    public ResponseEntity<Object> alterarContato(@PathVariable Integer id, @RequestParam String nome, String email){
        Contato contato = contatoService.update(id, nome, email);
        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }
}
