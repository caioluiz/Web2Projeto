package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Projeto;

import java.io.IOException;
import java.time.LocalDate;

import dao.ProjetoDAO;
import dao.CursoDAO;
import dao.ServicoDAO;


/**
 * Servlet implementation class ProjetoServlet
 */
@WebServlet("/prof/projetos")
public class ProjetoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {

	    String acao = req.getParameter("acao");

	    ProjetoDAO projetoDAO = new ProjetoDAO();
	    CursoDAO cursoDAO = new CursoDAO();
	    ServicoDAO servicoDAO = new ServicoDAO();

	    if (acao == null) {
	        req.setAttribute("lista", projetoDAO.listarTodos());
	        req.getRequestDispatcher("/view/professor/projetos-listar.jsp").forward(req, resp);
	        return;
	    }

	    if (acao.equals("form")) {

	        req.setAttribute("cursos", cursoDAO.listarTodos());
	        req.setAttribute("servicos", servicoDAO.listarTodos());

	        Projeto p = new Projeto(); 
	        req.setAttribute("projeto", p);

	        req.getRequestDispatcher("/view/professor/projetos-form.jsp").forward(req, resp);
	        return;
	    }

	    if (acao.equals("editar")) {
	        Integer id = Integer.valueOf(req.getParameter("id"));
	        Projeto p = projetoDAO.buscarPorId(id);

	        req.setAttribute("projeto", p);

	        req.setAttribute("cursos", cursoDAO.listarTodos());
	        req.setAttribute("servicos", servicoDAO.listarTodos());

	        req.getRequestDispatcher("/view/professor/projetos-form.jsp").forward(req, resp);
	        return;
	    }
	}


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String idParam = req.getParameter("id");
        Integer id = (idParam != null && !idParam.isBlank()) ? Integer.valueOf(idParam) : null;

        ProjetoDAO dao = new ProjetoDAO();
        Projeto p = (id == null) ? new Projeto() : dao.buscarPorId(id);

        p.setTitulo(req.getParameter("titulo"));
        p.setDescricao(req.getParameter("descricao"));
        p.setResponsavel(req.getParameter("responsavel"));
        p.setContatoInscricao(req.getParameter("contato"));
        p.setLinkExterno(req.getParameter("linkExterno"));
        p.setPublicoAlvo(req.getParameter("publicoAlvo"));
        p.setStatus(req.getParameter("status"));
        p.setTemTaxa(req.getParameter("temTaxa") != null);
        p.setLocal(req.getParameter("local"));

        p.setDataInicio(LocalDate.parse(req.getParameter("dataInicio")));
        p.setDataFim(LocalDate.parse(req.getParameter("dataFim")));
        
        p.setDuracao(req.getParameter("duracao"));
        p.setCursosIds(req.getParameter("cursosIds"));
        p.setServicosIds(req.getParameter("servicosIds"));

        dao.salvar(p);

        resp.sendRedirect(req.getContextPath() + "/prof/projetos");
    }
}