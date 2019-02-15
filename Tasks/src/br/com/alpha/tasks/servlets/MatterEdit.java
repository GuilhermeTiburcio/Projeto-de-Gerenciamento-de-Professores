package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.MatterController;
import br.com.alpha.tasks.domain.Matter;

@WebServlet(urlPatterns="/update-matter")
public class MatterEdit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("Cod", req.getParameter("Cod"));
		req.getRequestDispatcher("WEB-INF/professor/page-edit-matters.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Matter mat = new Matter();
		mat.setId(Integer.parseInt(req.getParameter("id")));
		mat.setName(req.getParameter("matter"));
		if(new MatterController().duplicateRegistration(mat))
			new MatterController().update(mat);
		resp.sendRedirect("matter");
	}
}
