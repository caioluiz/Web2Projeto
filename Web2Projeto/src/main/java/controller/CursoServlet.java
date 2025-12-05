package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import dao.CursoDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Curso;

@WebServlet("/prof/cursos")
public class CursoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String acao = req.getParameter("acao");

        if (acao == null) {
            CursoDAO dao = new CursoDAO();
            req.setAttribute("lista", dao.listarTodos());
            req.getRequestDispatcher("/view/professor/cursos-listar.jsp").forward(req, resp);
            return;
        }

        if ("form".equals(acao)) {
            req.getRequestDispatcher("/view/professor/cursos-form.jsp").forward(req, resp);
            return;
        }

        if ("editar".equals(acao)) {
            Integer id = Integer.parseInt(req.getParameter("id"));
            Curso c = new CursoDAO().buscarPorId(id);
            req.setAttribute("curso", c);
            req.getRequestDispatcher("/view/professor/cursos-form.jsp").forward(req, resp);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String idParam = req.getParameter("id");
        Integer id = (idParam != null && !idParam.isBlank()) ? Integer.valueOf(idParam) : null;

        CursoDAO dao = new CursoDAO();
        Curso c = (id == null) ? new Curso() : dao.buscarPorId(id);

        c.setTitulo(req.getParameter("titulo"));
        c.setDescricao(req.getParameter("descricao"));
        c.setResponsavel(req.getParameter("responsavel"));
        c.setContatoInscricao(req.getParameter("contato"));
        c.setLinkExterno(req.getParameter("linkExterno"));
        c.setPublicoAlvo(req.getParameter("publicoAlvo"));
        c.setStatus(req.getParameter("status"));
        c.setTemTaxa(req.getParameter("temTaxa") != null);
        c.setLocal(req.getParameter("local"));

        c.setDataInicio(LocalDate.parse(req.getParameter("dataInicio")));
        c.setDataFim(LocalDate.parse(req.getParameter("dataFim")));
        c.setHoraDeInicio(LocalTime.parse(req.getParameter("horaInicio")));
        c.setHoraDeTermino(LocalTime.parse(req.getParameter("horaFim")));

        c.setMaxParticipantes(Integer.parseInt(req.getParameter("maxParticipantes")));
        c.setNivel(req.getParameter("nivel"));
        c.setModalidade(req.getParameter("modalidade"));
        c.setDuracaoTotal(req.getParameter("duracaoTotal"));
        c.setMaxParticipantes(parseIntSafe(req.getParameter("maxParticipantes"), 0));
        c.setCargaHorariaSemanal(parseDoubleSafe(req.getParameter("cargaHorariaSemanal"), 0.0));
        dao.salvar(c);

        resp.sendRedirect(req.getContextPath() + "/prof/cursos");
    }
    
    private Integer parseIntSafe(String s, Integer def) {
        if (s == null || s.isBlank()) return def;
        try { return Integer.valueOf(s); }
        catch (NumberFormatException ex) { return def; }
    }

    private Double parseDoubleSafe(String s, Double def) {
        if (s == null || s.isBlank()) return def;
        try { return Double.valueOf(s); }
        catch (NumberFormatException ex) { return def; }
    }
}
