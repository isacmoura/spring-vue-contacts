package ufc.quixada.autoestudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufc.quixada.autoestudo.model.Contato;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ContatoRepository extends JpaRepository <Contato, Integer>{

    Contato findByNome(String nome);

}
