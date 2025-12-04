package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Servico;
import dao.ServicoDAO;

import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ServicoServlet
 */
@WebServlet("/ServicoServlet")
public class ServicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public ServicoServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

        switch (action) {
        	case "form": //formulario
        		request.getRequestDispatcher("/view/professor/servicos-form.jsp").forward(request, response);
                break;
			default: //listar servicos
				ServicoDAO dao = new ServicoDAO();
                request.setAttribute("lista", dao.listarTodos());
                request.getRequestDispatcher("/view/professor/servicos-listar.jsp").forward(request, response);
				break;
            	

        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        Servico servico = new Servico();
        
        servico.setTitulo(request.getParameter("titulo"));
        servico.setDescricao(request.getParameter("descricao"));
        servico.setResponsavel(request.getParameter("responsavel"));
        servico.setContatoInscricao(request.getParameter("contato"));
        servico.setLinkExterno(request.getParameter("linkExterno"));
        servico.setPublicoAlvo(request.getParameter("publicoAlvo"));
        servico.setStatus(request.getParameter("status"));
        
        servico.setTipoServico(request.getParameter("tipoServico"));
        servico.setHorarioInicio(LocalTime.parse(request.getParameter("horarioInicio")));
        servico.setHorarioFim(LocalTime.parse(request.getParameter("horarioFim")));
        servico.setTipoServico(request.getParameter("modalidadeAtendimento"));
        servico.setTaxa(Integer.parseInt(request.getParameter("taxa")));

        
        //dias de atendimento values:
        //MONDAY
        //TUESDAY
        //WEDNESDAY
        //THURSDAY
        //FRIDAY
        //SATURDAY
        //SUNDAY

        String[] diasAtendimento = request.getParameterValues("diasAtendimento");

        List<DayOfWeek> dias = new ArrayList<>();

        if (diasAtendimento != null) {
            for (String d : diasAtendimento) {
                dias.add(DayOfWeek.valueOf(d));
            }
        }
        servico.setDiasAtendimento(dias);
        
        new ServicoDAO().salvar(servico);
        
        response.sendRedirect(request.getContextPath() + "/prof/servicos");
	}
}
