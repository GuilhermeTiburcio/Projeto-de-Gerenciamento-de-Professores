package br.com.alpha.tasks.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.MatterController;
import br.com.alpha.tasks.controller.QuestionController;
import br.com.alpha.tasks.controller.TestController;
import br.com.alpha.tasks.domain.Class;
import br.com.alpha.tasks.domain.Matter;
import br.com.alpha.tasks.domain.Question;
import br.com.alpha.tasks.domain.Test;

@WebServlet(urlPatterns = "/testAdd")
public class TestAdd extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("WEB-INF/professor/page-add-test.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Test t = new Test();
		List<Question> listQuestion = new ArrayList<Question>();
		Class c = new Class();
		c.setName(req.getParameter("class"));
		Matter m = new Matter();
		m.setName(req.getParameter("matter"));
		Matter matter = (Matter) new MatterController().getElementByName(m
				.getName());
		for (int i = 1; i <= new QuestionController().getListOfMatter(
				matter.getId()).size(); i++) {
			if (req.getParameter("check" + i) != null) {
				Question q = new Question();
				q.setId(Integer.parseInt(req.getParameter("check" + i)));
				listQuestion.add(q);
			}
		}
		
		t.setClas(c);
		t.setMatter(m);
		t.setListQuestion(listQuestion);
		
		new TestController().add(t);
		
		resp.sendRedirect("test");

	}
}
