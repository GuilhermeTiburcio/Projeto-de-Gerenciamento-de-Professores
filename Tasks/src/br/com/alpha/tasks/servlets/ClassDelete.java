package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.ClassController;
import br.com.alpha.tasks.domain.Class;

@WebServlet(urlPatterns="/delete-class")
public class ClassDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Class c = new Class();
		c.setId(Integer.parseInt(req.getParameter("Cod")));
		new ClassController().delete(c);
		resp.sendRedirect("class");
	}
}
