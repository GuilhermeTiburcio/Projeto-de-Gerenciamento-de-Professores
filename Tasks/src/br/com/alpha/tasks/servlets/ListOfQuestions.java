package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.MatterController;
import br.com.alpha.tasks.controller.QuestionController;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Matter;
import br.com.alpha.tasks.domain.Question;

@WebServlet(urlPatterns = "/list-of-question")
public class ListOfQuestions extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (!req.getParameter("matter").equals("Select Matter")) {
			resp.getWriter().println("<br><br>");
			resp.getWriter().println(
					"<table class='table' id='table'>" + "<thead>" + "	<tr>"
							+ "<th scope='col'><center>Select</center></th>"
							+ "	<th scope='col'><center>Statement</center></th>"
							+ "</tr>" + "</thead>" + "<tbody>");
			int i = 1;
			Matter m = (Matter) new MatterController().getElementByName(req.getParameter("matter"));
			for(IDomain domain : new QuestionController().getListOfMatter(m.getId())){
				Question q = (Question) domain;
				resp.getWriter().println("<tr id='tr'>");
				resp.getWriter().println("<td><center><input type='checkbox' class='form-control' id='check"+i+"' name='check"+i+"' value='"+q.getId()+"'/></center></td>");
				resp.getWriter().println("<td><center>"+q.getStatement()+"</center></td>");
				i++;
			}
		}
		
		
		
	}
}
