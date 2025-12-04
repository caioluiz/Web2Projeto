package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Programa;
import util.JPAUtil;

public class ProgramaDAO {

	public ProgramaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salvar(Programa programa) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(programa);
        em.getTransaction().commit();
        em.close();
    }
	
	public List<Programa> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Programa> q = em.createQuery("SELECT e FROM Programa e ORDER BY e.dataInicio DESC", Programa.class);
        return q.getResultList();
    }
	
	public Programa buscarPorId(int id) {
        return JPAUtil.getEntityManager().find(Programa.class, id);
    }
	
	public void atualizar(Programa programa) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(programa);
        em.getTransaction().commit();
        em.close();
    }

}
