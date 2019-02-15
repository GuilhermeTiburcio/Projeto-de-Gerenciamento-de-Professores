package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/save-student")
public class AddStudentServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("professor/page-add-student.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/professor/page-add-student.jsp");
		rd.forward(req, resp);
	}
}
