package ufc.quixada.autoestudo.service;

import ufc.quixada.autoestudo.model.Contato;

import java.util.List;

public interface IContatoService {
    List<Contato> findAll();
    Contato findByNome(String nome);
    Contato findById(Integer id);
    void saveContact(Contato contato);
    Contato update(Contato contato);
    void remove(Contato contato);
}
