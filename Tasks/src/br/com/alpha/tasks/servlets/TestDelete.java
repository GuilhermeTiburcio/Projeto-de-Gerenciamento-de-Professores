package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.TestController;
import br.com.alpha.tasks.domain.Test;

@WebServlet(urlPatterns="/test-delete")
public class TestDelete extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int cod = Integer.parseInt(req.getParameter("Cod"));
		Test t = new Test();
		t.setId(cod);
		new TestController().delete(t);
		resp.sendRedirect("test");
	}
}
