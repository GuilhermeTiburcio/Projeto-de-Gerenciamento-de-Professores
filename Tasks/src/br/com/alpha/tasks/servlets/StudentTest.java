package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.LoginController;

@WebServlet(urlPatterns = "/student-test")
public class StudentTest extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("Test", req.getParameter("Test"));
		req.getRequestDispatcher("WEB-INF/student/page-test-student.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int qnt = Integer.parseInt(req.getParameter("qntradios"));
		int certas = 0;
		int erradas = 0;
		for (int i = 1; i <= qnt; i++) {
			if (req.getParameter("radio" + i) != null) {
				if (req.getParameter("radio" + i).equalsIgnoreCase("certa"))
					certas++;
				else
					erradas++;
			}else{
				erradas++;
			}
		}
		int id_student = Integer.parseInt(req.getParameter("sid"));
		int id_test = Integer.parseInt(req.getParameter("Test"));
		double qntQuestion = Double.parseDouble(req.getParameter("qntQuestions"));
		double valorQuestao = 10 / qntQuestion;
		

		double final_grade = valorQuestao * certas;
		
		
		new LoginController().TestStudentFinal(id_student, id_test, certas, erradas, final_grade);
		
		resp.sendRedirect("student-home");
	}
}
