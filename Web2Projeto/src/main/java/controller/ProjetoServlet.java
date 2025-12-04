package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import model.Projeto;
import model.Servico;

import java.io.IOException;

import dao.ProjetoDAO;
import dao.ServicoDAO;

/**
 * Servlet implementation class ProjetoServlet
 */
@WebServlet("/prof/projetos")
public class ProjetoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjetoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        switch (action) {
        	case "form": //formulario
        		request.getRequestDispatcher("/view/professor/projetos-form.jsp").forward(request, response);
                break;
			default: //listar projetos
				ProjetoDAO dao = new ProjetoDAO();
                request.setAttribute("lista", dao.listarTodos());
                request.getRequestDispatcher("/view/professor/projetos-listar.jsp").forward(request, response);
				break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        Projeto projeto = new Projeto();
        
        projeto.setTitulo(request.getParameter("titulo"));
        projeto.setDescricao(request.getParameter("descricao"));
        projeto.setResponsavel(request.getParameter("responsavel"));
        projeto.setContatoInscricao(request.getParameter("contato"));
        projeto.setLinkExterno(request.getParameter("linkExterno"));
        projeto.setPublicoAlvo(request.getParameter("publicoAlvo"));
        projeto.setStatus(request.getParameter("status"));
        
        int idCurso = Integer.parseInt(request.getParameter("idCurso"));
        CursoDAO cursoDAO = new CursoDAO();
        Curso curso = cursoDAO.buscarPorId(idCurso);
        if (curso != null) {
            projeto.addCurso(curso);
        }
        
        int idServico = Integer.parseInt(request.getParameter("idServico"));
        ServicoDAO servicoDAO = new ServicoDAO();
        Servico servico = servicoDAO.buscarPorId(idServico);
        if (servico != null) {
            projeto.addServico(servico);
        }
        
        response.sendRedirect(request.getContextPath() + "/prof/projetos");
        
	}

}
