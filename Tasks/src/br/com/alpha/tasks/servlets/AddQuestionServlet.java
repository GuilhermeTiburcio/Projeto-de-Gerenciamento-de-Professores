package br.com.alpha.tasks.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.QuestionController;
import br.com.alpha.tasks.domain.Alternatives;
import br.com.alpha.tasks.domain.Question;

@WebServlet(urlPatterns="/addQuestions")
public class AddQuestionServlet extends HttpServlet{
	private Question question;
	private Alternatives alternative;
	private ArrayList<Alternatives> arrayAlternatives;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		arrayAlternatives = new ArrayList<Alternatives>();
		String certa = req.getParameter("radio");
		question = new Question();
		question.setStatement(req.getParameter("statement"));
		question.setLevel(Integer.parseInt(req.getParameter("level")));
		question.setTheme(req.getParameter("theme"));
		question.setDiscipline(req.getParameter("matter"));
		alternative = new Alternatives();
		alternative.setText(req.getParameter("Alternative1"));
		if(certa.equalsIgnoreCase("A"))
			alternative.setChecked(true);
		else
			alternative.setChecked(false);
		
		arrayAlternatives.add(alternative);
		
		alternative = new Alternatives();
		alternative.setText(req.getParameter("Alternative2"));
		if(certa.equalsIgnoreCase("B"))
			alternative.setChecked(true);
		else
			alternative.setChecked(false);
		
		arrayAlternatives.add(alternative);
		
		alternative = new Alternatives();
		alternative.setText(req.getParameter("Alternative3"));
		if(certa.equalsIgnoreCase("C"))
			alternative.setChecked(true);
		else
			alternative.setChecked(false);
		
		arrayAlternatives.add(alternative);
		
		alternative = new Alternatives();
		alternative.setText(req.getParameter("Alternative4"));
		if(certa.equalsIgnoreCase("D"))
			alternative.setChecked(true);
		else
			alternative.setChecked(false);
		
		arrayAlternatives.add(alternative);
		
		alternative = new Alternatives();
		alternative.setText(req.getParameter("Alternative5"));
		if(certa.equalsIgnoreCase("E"))
			alternative.setChecked(true);
		else
			alternative.setChecked(false);
		
		arrayAlternatives.add(alternative);
		
		question.setAlternatives(arrayAlternatives);
		
		QuestionController.add(question);
		
		resp.sendRedirect("questions");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/professor/page-add-question.jsp");
		rd.forward(req, resp);
	}
}
