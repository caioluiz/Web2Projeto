package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Servico;
import util.JPAUtil;

public class ServicoDAO {

	public ServicoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salvar(Servico servico) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(servico);
        em.getTransaction().commit();
        em.close();
    }
	
	public List<Servico> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Servico> q = em.createQuery("SELECT e FROM Servico e ORDER BY e.dataInicio DESC", Servico.class);
        return q.getResultList();
    }
	
	public Servico buscarPorId(int id) {
        return JPAUtil.getEntityManager().find(Servico.class, id);
    }
	
	public void atualizar(Servico servico) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(servico);
        em.getTransaction().commit();
        em.close();
    }
}
