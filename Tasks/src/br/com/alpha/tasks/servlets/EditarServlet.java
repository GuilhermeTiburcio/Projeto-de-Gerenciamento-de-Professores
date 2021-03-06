package br.com.alpha.tasks.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.UserController;
import br.com.alpha.tasks.controller.Valid;
import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;
@WebServlet(urlPatterns="/update")
public class EditarServlet extends HttpServlet {
	private User u = null;
	private String nome,senha,email,tipo;
	private UserController uc = null;
	private int id = 0;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		u = new User();
		id = (int) req.getSession().getAttribute("idUser");	
		nome = req.getParameter("name");
		senha = req.getParameter("pass");
		email = req.getParameter("email");
		tipo = req.getParameter("radio");
		u.setId(id);
		u.setName(nome);
		u.setPassword(senha);
		u.setLogin(email);
		u.setType(TYPE_USER.PROFESSOR);
		uc = new UserController();
		uc.update(u);
		req.setAttribute("allUsers", new UserController().getList());
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/professor/page-professor.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/professor/page-edit.jsp").forward(req, resp);
	}
}
