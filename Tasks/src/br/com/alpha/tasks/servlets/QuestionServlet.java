package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.QuestionController;
import br.com.alpha.tasks.controller.UserController;

@WebServlet(urlPatterns = "/questions")
public class QuestionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("allQuestions", new QuestionController().getList());
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/professor/page-questions.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("allQuestions", new QuestionController().getList());
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/professor/page-questions.jsp");
		rd.forward(req, resp);
	}
}
