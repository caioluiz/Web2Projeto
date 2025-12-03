package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Servico;
import dao.ServicoDAO;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class ServicoServlet
 */
@WebServlet("/ServicoServlet")
public class ServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ServicoDAO servicoDAO;

    /**
     * Default constructor. 
     */
    public ServicoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
        servicoDAO = new ServicoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        switch (action) {
        	case "listar":
        		listarServicos(request, response);
        		break;
        		
            case "adicionar":
                mostrarFormNovo(request, response);
                break;
            case "editar":
                carregarServico(request, response);
                break;

            case "remover":
                removerServico(request, response);
                break;

        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

	private void listarServicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Servico> lista = ServicoDAO.listarTodos();
        request.setAttribute("servicos", lista);
        request.getRequestDispatcher("nomejsp").forward(request, response); // falta o jsp
    }
	
	
}
