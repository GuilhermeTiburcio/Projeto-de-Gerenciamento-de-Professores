package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.StudentController;
import br.com.alpha.tasks.domain.Student;
import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;

@WebServlet(urlPatterns = "/update-student")
public class StudentUpdate extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("cod", req.getParameter("Cod"));
		req.getRequestDispatcher("WEB-INF/professor/page-edit-student.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = new Student();
		int id = Integer.parseInt(req.getParameter("id"));
		s.setRa(Integer.parseInt(req.getParameter("ra")));
		s.setLogin(req.getParameter("email"));
		s.setPassword(req.getParameter("pass"));
		s.setName(req.getParameter("name"));
		s.setId(id);
		s.setType(TYPE_USER.STUDENT);
		//if (new StudentController().duplicateRegistration(s)) {
			new StudentController().update(s);
		//}
		resp.sendRedirect("students");
	}
}
