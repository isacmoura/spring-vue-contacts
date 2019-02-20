package ufc.quixada.autoestudo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ufc.quixada.autoestudo.model.Contato;
import ufc.quixada.autoestudo.repository.ContatoRepository;

import java.util.List;

@Service
public class ContatoService implements IContatoService {
    @Autowired
    private ContatoRepository contatoRepository;

    @Override
    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    @Override
    public Contato findByNome(String nome) {
        return contatoRepository.findByNome(nome);
    }

    @Override
    public Contato findById(Integer id) {
        return contatoRepository.findById(id);
    }

    @Override
    public void saveContact(Contato contato) {
        contatoRepository.saveContact(contato);
    }

    @Override
    public Contato update(Contato contato) {
        return contatoRepository.update(contato);
    }

    @Override
    public void remove(Contato contato) {
        contatoRepository.remove(contato);
    }
}
