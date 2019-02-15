package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.MatterController;
import br.com.alpha.tasks.domain.Matter;

@WebServlet(urlPatterns = "/delete-matter")
public class MatterDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Matter mat = new Matter();
		mat.setId(Integer.parseInt(req.getParameter("Cod")));
		new MatterController().delete(mat);
		resp.sendRedirect("matter");
	}
}
