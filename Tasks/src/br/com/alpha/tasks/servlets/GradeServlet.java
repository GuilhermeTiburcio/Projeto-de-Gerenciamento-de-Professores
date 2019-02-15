package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.GradeController;

@WebServlet(urlPatterns="/grades")
public class GradeServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("list", new GradeController().getList());
		req.getRequestDispatcher("WEB-INF/professor/page-grade.jsp").forward(req, resp);
	}
}
