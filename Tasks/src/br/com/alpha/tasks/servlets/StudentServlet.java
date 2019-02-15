package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.StudentController;

@WebServlet(urlPatterns="/students")
public class StudentServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("list", new StudentController().getList());
		req.getRequestDispatcher("WEB-INF/professor/page-student.jsp").forward(req, resp);
	}
}
