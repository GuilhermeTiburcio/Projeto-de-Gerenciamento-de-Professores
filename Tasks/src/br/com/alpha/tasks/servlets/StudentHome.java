package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.LoginController;
import br.com.alpha.tasks.domain.Student;

@WebServlet(urlPatterns="/student-home")
public class StudentHome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int id = (int) req.getSession().getAttribute("idStudent");
		Student s = new LoginController().pegaStudent(id);
		req.getSession().setAttribute("studentsIds", s.getId());
		req.getRequestDispatcher("WEB-INF/student/page-student.jsp").forward(req, resp);
	}
}
