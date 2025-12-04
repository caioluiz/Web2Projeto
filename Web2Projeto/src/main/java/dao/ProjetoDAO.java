package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Projeto;
import util.JPAUtil;

public class ProjetoDAO {

	public ProjetoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void salvar(Projeto projeto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(projeto);
        em.getTransaction().commit();
        em.close();
    }
	
	public List<Projeto> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Projeto> q = em.createQuery("SELECT e FROM Projeto e ORDER BY e.dataInicio DESC", Projeto.class);
        return q.getResultList();
    }
	
	public Projeto buscarPorId(int id) {
        return JPAUtil.getEntityManager().find(Projeto.class, id);
    }
	
	public void atualizar(Projeto projeto) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(projeto);
        em.getTransaction().commit();
        em.close();
    }
}
