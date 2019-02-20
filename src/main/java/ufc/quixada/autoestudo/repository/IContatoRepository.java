package ufc.quixada.autoestudo.repository;

import ufc.quixada.autoestudo.model.Contato;

import java.util.List;

public interface IContatoRepository{
    List<Contato> findAll();
    Contato findByNome(String nome);
    Contato findById(Integer id);
    void saveContact(Contato contato);
    Contato updateById(Integer id, Contato contato);
    void remove(Contato contato);

}
