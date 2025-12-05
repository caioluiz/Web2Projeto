package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import util.JPAUtil;
import jakarta.persistence.EntityManager;

@WebServlet(loadOnStartup = 1, urlPatterns = "/initdb")
public class InitDBServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void init() throws ServletException {
        EntityManager em = JPAUtil.getEntityManager();
        em.close();
        System.out.println(">>> Hibernate inicializado! Tabelas criadas (se necessário).");
    }
}
