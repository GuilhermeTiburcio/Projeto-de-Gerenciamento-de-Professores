package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.StudentController;
import br.com.alpha.tasks.domain.Student;

@WebServlet(urlPatterns="/ra-duplicate")
public class DuplicateStudent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Student s = new Student();
		s.setRa(Integer.parseInt(req.getParameter("ra")));
		if(!new StudentController().duplicateRegistration(s)){
			resp.getWriter().print("<input type='hidden' id='veri' name='veri' value='1'>");
		}else{
			resp.getWriter().print("<input type='hidden' id='veri' name='veri' value='0'>");
		}
	}
}
