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
import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;
@WebServlet(urlPatterns="/delete")
public class ExcluirServlet extends HttpServlet{
	private UserController uc;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User u = new User();
		u.setId(Integer.parseInt(req.getParameter("Cod")));
		if(TYPE_USER.PROFESSOR.equals(req.getParameter("type")))
			u.setType(TYPE_USER.PROFESSOR);
		else 
			u.setType(TYPE_USER.STUDENT);
		uc = new UserController();
		uc.delete(u);
		req.setAttribute("allUsers", new UserController().getList());
		resp.sendRedirect("initial");
	}
}