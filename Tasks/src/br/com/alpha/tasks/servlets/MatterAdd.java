package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.alpha.tasks.controller.MatterController;
import br.com.alpha.tasks.domain.Matter;

@WebServlet(urlPatterns = "/matteradd")
public class MatterAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Matter mat = new Matter();
		mat.setName(req.getParameter("matter"));
		if (new MatterController().duplicateRegistration(mat)) 
			new MatterController().add(mat);
		resp.sendRedirect("matter");
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/professor/page-add-matters.jsp")
				.forward(req, resp);
	}
}
