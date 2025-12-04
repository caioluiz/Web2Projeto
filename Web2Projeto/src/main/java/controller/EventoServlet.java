package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.EventoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Evento;

@WebServlet("/prof/eventos")
public class EventoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");
        EventoDAO dao = new EventoDAO();

        if (acao == null) {
            // LISTAR
            req.setAttribute("lista", dao.listarTodos());
            req.getRequestDispatcher("/view/professor/eventos-listar.jsp").forward(req, resp);
            return;
        }

        if (acao.equals("form")) {
            // FORMULÁRIO EM BRANCO
            req.getRequestDispatcher("/view/professor/eventos-form.jsp").forward(req, resp);
            return;
        }

        if (acao.equals("editar")) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Evento e = dao.buscarPorId(id);
            req.setAttribute("evento", e);
            req.getRequestDispatcher("/view/professor/eventos-form.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        EventoDAO dao = new EventoDAO();
        Evento e;

        // SE TIVER ID → atualizar
        if (req.getParameter("id") != null && !req.getParameter("id").isEmpty()) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            e = dao.buscarPorId(id);
        } else {
            e = new Evento();
        }

        e.setTitulo(req.getParameter("titulo"));
        e.setDescricao(req.getParameter("descricao"));
        e.setResponsavel(req.getParameter("responsavel"));
        e.setContatoInscricao(req.getParameter("contato"));
        e.setLinkExterno(req.getParameter("linkExterno"));
        e.setPublicoAlvo(req.getParameter("publicoAlvo"));
        e.setStatus(req.getParameter("status"));
        e.setTemTaxa(req.getParameter("temTaxa") != null);

        e.setDataInicio(LocalDate.parse(req.getParameter("dataInicio")));
        e.setDataFim(LocalDate.parse(req.getParameter("dataFim")));
        e.setHoraDeInicio(LocalTime.parse(req.getParameter("horaInicio")));
        e.setHoraDeTermino(LocalTime.parse(req.getParameter("horaFim")));
        e.setMaxParticipantes(Integer.parseInt(req.getParameter("maxParticipantes")));
        e.setLocal(req.getParameter("local"));

        dao.salvar(e);

        resp.sendRedirect(req.getContextPath() + "/prof/eventos");
    }
}
