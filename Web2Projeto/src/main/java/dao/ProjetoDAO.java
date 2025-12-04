package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Projeto;
import util.JPAUtil;

public class ProjetoDAO {

    public void salvar(Projeto p) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        if (p.getId() == null) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
        em.close();
    }

    public Projeto buscarPorId(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Projeto p = em.find(Projeto.class, id);
        em.close();
        return p;
    }

    public List<Projeto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        Query q = em.createQuery("SELECT p FROM Projeto p ORDER BY p.dataInicio DESC");
        List<Projeto> lista = q.getResultList();
        em.close();
        return lista;
    }

    public void excluir(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Projeto p = em.find(Projeto.class, id);
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
        em.close();
    }
}