package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.StudentController;
import br.com.alpha.tasks.domain.Student;

@WebServlet(urlPatterns = "/studentAddm")
public class StudentAddAdm extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/professor/page-add-student-adm.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = new Student();
		s.setRa(Integer.parseInt(req.getParameter("ra")));
		s.setLogin(req.getParameter("email"));
		s.setPassword(req.getParameter("pass"));
		s.setName(req.getParameter("name"));
		if (new StudentController().duplicateRegistration(s)) {
			new StudentController().add(s);
		}
		resp.sendRedirect("students");
	}
}
