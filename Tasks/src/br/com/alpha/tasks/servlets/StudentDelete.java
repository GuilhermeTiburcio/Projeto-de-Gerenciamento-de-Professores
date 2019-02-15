package br.com.alpha.tasks.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alpha.tasks.controller.StudentController;
import br.com.alpha.tasks.domain.User;

@WebServlet(urlPatterns = "/student-delete")
public class StudentDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		User s = new User();
		s.setId(Integer.parseInt(req.getParameter("Cod")));
		new StudentController().delete(s);
		resp.sendRedirect("students");
	}
}