package dao;

import jakarta.persistence.NoResultException;
import jakarta.persistence.EntityManager;
import model.Aluno;
import model.Professor;
import util.JPAUtil;

public class PessoaDAO {

    public Object autenticar(String email, String senha) {

        EntityManager em = JPAUtil.getEntityManager();

        try {
            Aluno aluno = em.createQuery(
                "SELECT a FROM Aluno a WHERE a.email = :email AND a.senha = :senha",
                Aluno.class
            )
            .setParameter("email", email)
            .setParameter("senha", senha)
            .getSingleResult();

            return aluno;

        } catch (NoResultException e) {
        }

        try {
            Professor prof = em.createQuery(
                "SELECT p FROM Professor p WHERE p.email = :email AND p.senha = :senha",
                Professor.class
            )
            .setParameter("email", email)
            .setParameter("senha", senha)
            .getSingleResult();

            return prof;

        } catch (NoResultException e) {
            return null; // login inválido
        }
    }
}
