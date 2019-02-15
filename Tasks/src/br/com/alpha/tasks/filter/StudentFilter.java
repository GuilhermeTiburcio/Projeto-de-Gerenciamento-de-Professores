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



//@WebFilter(urlPatterns = { "/student/*" })
public class StudentFilter {

	/*@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		HttpServletRequest request = (HttpServletRequest) req;
		String accessUri = request.getRequestURI();

		System.out.println("Student is acessing " + accessUri);

		HttpServletResponse response = (HttpServletResponse) resp;

		User user = (User) request.getSession().getAttribute("user");
		
		System.out.println("TYPE: "+user.getType().toString());
		
		if (user != null) {

			if (!user.getType().equals(TYPE_USER.STUDENT)) {

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
