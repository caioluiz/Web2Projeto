package controller;

import java.io.IOException;

import dao.PessoaDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Aluno;
import model.Professor;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        PessoaDAO dao = new PessoaDAO();
        Object usuario = dao.autenticar(email, senha);

        if (usuario == null) {
            req.setAttribute("erro", "Credenciais inválidas!");
            req.getRequestDispatcher("view/login.jsp").forward(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        session.setAttribute("usuario", usuario);

        if (usuario instanceof Aluno) {
            resp.sendRedirect("view/aluno/home.jsp");
        } else {
            resp.sendRedirect("view/professor/index.jsp");
        }
    }
}
