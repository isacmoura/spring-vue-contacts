package ufc.quixada.autoestudo.repository;

import ufc.quixada.autoestudo.model.Contato;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

public class ContatoRepository implements IContatoRepository {
    protected EntityManager em;

    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Contato> findAll() {
        Query query = em.createQuery("from Contato");
        return query.getResultList();

    }

    @Override
    public Contato findByNome(String nome) {
        Contato contato = em.find(Contato.class, nome);
        return contato;
    }

    @Override
    public Contato findById(Integer id) {
        Contato contato = em.find(Contato.class, id);
        return contato;
    }

    @Override
    @Transactional
    public void saveContact(Contato contato) {
        em.persist(contato);
    }

    @Override
    @Transactional
    public Contato updateById(Integer id, Contato contato) {
        contato = em.find(Contato.class, id);
        contato.setNome(contato.getNome());
        contato.setEmail(contato.getEmail());
        return contato;
    }

    @Override
    @Transactional
    public void remove(Contato contato) {
        em.remove(em.merge(contato));
    }
}
