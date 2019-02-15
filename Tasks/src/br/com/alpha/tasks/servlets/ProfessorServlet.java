package br.com.alpha.tasks.servlets;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.UserController;

@WebServlet(urlPatterns = "/initial")
public class ProfessorServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//req.getSession().setAttribute("user", user);
		req.setAttribute("allUsers", new UserController().getList());
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/professor/page-professor.jsp");
		rd.forward(req, resp);
	}
}