package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Curso;
import util.JPAUtil;

public class CursoDAO {

	public void salvar(Curso c) {
	    EntityManager em = JPAUtil.getEntityManager();
	    em.getTransaction().begin();
	    em.merge(c); // merge funciona para novo e existente
	    em.getTransaction().commit();
	    em.close();
	}

    public List<Curso> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Curso> q = em.createQuery("SELECT c FROM Curso c ORDER BY c.dataInicio DESC", Curso.class);
        List<Curso> lista = q.getResultList();
        em.close();
        return lista;
    }

    public Curso buscarPorId(Integer id) {
        EntityManager em = JPAUtil.getEntityManager();
        Curso c = em.find(Curso.class, id);
        em.close();
        return c;
    }
}
