package br.com.alpha.tasks.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;

//@WebFilter(urlPatterns = { "/professor/*" })
public class ProfessorFilter {

	/*@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest request = (HttpServletRequest) req;

		String accessURI = request.getRequestURI();

		System.out.println("Professor is acessing " + accessURI);

		User user = (User) request.getSession().getAttribute("user");

		HttpServletResponse response = (HttpServletResponse) resp;

		if (user != null) {

			if (!user.getType().equals(TYPE_USER.PROFESSOR)) {

				response.sendRedirect("/Tasks/index.html");

			}

		} else {

			response.sendRedirect("/Tasks/index.html");

		}

		chain.doFilter(req, resp);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}*/

}
