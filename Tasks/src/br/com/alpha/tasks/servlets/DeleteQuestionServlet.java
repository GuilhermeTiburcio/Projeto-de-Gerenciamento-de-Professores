package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.QuestionController;
import br.com.alpha.tasks.domain.Question;

@WebServlet(urlPatterns="/delete-question")
public class DeleteQuestionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Question q = new Question();
		q.setId(Integer.parseInt(req.getParameter("Cod")));
		QuestionController.delete(q);
		resp.sendRedirect("questions");
	}
}
