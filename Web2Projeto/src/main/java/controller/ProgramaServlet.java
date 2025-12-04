package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Curso;
import model.Programa;
import model.Projeto;
import model.Servico;
import model.Evento;

import java.io.IOException;

import dao.ProgramaDAO;
import dao.ProjetoDAO;
import dao.ServicoDAO;
import dao.EventoDAO;
import dao.CursoDAO;

/**
 * Servlet implementation class ProgramaServlet
 */
@WebServlet("/prof/programas")
public class ProgramaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProgramaServlet() {
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
        		request.getRequestDispatcher("/view/professor/programas-form.jsp").forward(request, response);
                break;
			default: //listar programas
				ProgramaDAO dao = new ProgramaDAO();
                request.setAttribute("lista", dao.listarTodos());
                request.getRequestDispatcher("/view/professor/programas-listar.jsp").forward(request, response);
				break;
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        Programa programa = new Programa();
        
        
        programa.setTitulo(request.getParameter("titulo"));
        programa.setDescricao(request.getParameter("descricao"));
        programa.setResponsavel(request.getParameter("responsavel"));
        programa.setContatoInscricao(request.getParameter("contato"));
        programa.setLinkExterno(request.getParameter("linkExterno"));
        programa.setPublicoAlvo(request.getParameter("publicoAlvo"));
        programa.setStatus(request.getParameter("status"));
        
        String idCursoStr = request.getParameter("idCurso");
        if (idCursoStr != null && !idCursoStr.isEmpty()) {
            try {
                int idCurso = Integer.parseInt(idCursoStr);
                CursoDAO cursoDAO = new CursoDAO();
                Curso curso = cursoDAO.buscarPorId(idCurso);
                if (curso != null) {
                    programa.addCurso(curso);
                }
            } 
            catch (NumberFormatException e) {
            }
        }
        
        String idEventoStr = request.getParameter("idEvento");
        if (idEventoStr != null && !idEventoStr.isEmpty()) {
            try {
                int idEvento = Integer.parseInt(idEventoStr);
                EventoDAO EventoDAO = new EventoDAO();
                Evento evento = EventoDAO.buscarPorId(idEvento);
                if (evento != null) {
                    programa.addEvento(evento);
                }
            } 
            catch (NumberFormatException e) {
            }
        }
        
        String idServicoStr = request.getParameter("idServico");
        if (idServicoStr != null && !idServicoStr.isEmpty()) {
            try {
                int idServico = Integer.parseInt(idServicoStr);
                ServicoDAO servicoDAO = new ServicoDAO();
                Servico servico = servicoDAO.buscarPorId(idServico);
                if (servico != null) {
                    programa.addServico(servico);
                }
            } 
            catch (NumberFormatException e) {
            }
        }
        
        String idProjetoStr = request.getParameter("idProjeto");
        if (idProjetoStr != null && !idProjetoStr.isEmpty()) {
            try {
                int idProjeto = Integer.parseInt(idProjetoStr);
                ProjetoDAO projetoDAO = new ProjetoDAO();
                Projeto projeto = projetoDAO.buscarPorId(idProjeto);
                if (projeto != null) {
                    programa.addProjeto(projeto);
                }
            } 
            catch (NumberFormatException e) {
            }
        }
        ProgramaDAO programaDAO = new ProgramaDAO();

        programaDAO.salvar(programa);
        
        response.sendRedirect(request.getContextPath() + "/prof/programas");
        
	}
}
