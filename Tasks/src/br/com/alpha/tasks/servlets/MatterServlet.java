package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.MatterController;

@WebServlet(urlPatterns="/matter")
public class MatterServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("AllMatter", new MatterController().getList());
		req.getRequestDispatcher("WEB-INF/professor/page-matters.jsp").forward(req, resp);
	}
}
