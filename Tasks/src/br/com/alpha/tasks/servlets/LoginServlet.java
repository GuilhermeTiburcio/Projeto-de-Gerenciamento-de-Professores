package br.com.alpha.tasks.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.LoginController;
import br.com.alpha.tasks.controller.UserController;
import br.com.alpha.tasks.controller.Valid;
import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	User user = null;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String login = req.getParameter("email");
		String password = req.getParameter("password");

		user = LoginController.login(login, password);
		if (user != null) {
			if (user.getType() == TYPE_USER.PROFESSOR) {

				resp.sendRedirect("initial");

			} else if (user.getType() == TYPE_USER.STUDENT) {

				req.getSession().setAttribute("idStudent", user.getId());
				resp.sendRedirect("student-home");
			} else {

				resp.sendRedirect("index.html");
			}
		} else {
			resp.sendRedirect("index.html");
		}

	}
}
