package br.com.alpha.tasks.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alpha.tasks.controller.ClassController;
import br.com.alpha.tasks.controller.StudentController;
import br.com.alpha.tasks.controller.Valid;
import br.com.alpha.tasks.domain.Class;
import br.com.alpha.tasks.domain.Student;

@WebServlet(urlPatterns="/classAdd")
public class ClassAdd extends HttpServlet {
	private Student stu = null;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("List", new StudentController().getList());
		req.getRequestDispatcher("WEB-INF/professor/page-add-class.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Class c = new Class();
		c.setName(req.getParameter("name"));
		c.setStartDate(Valid.data(req.getParameter("start")));
		c.setFinalDate(Valid.data(req.getParameter("final")));
		c.setDescription(req.getParameter("description"));
		List<Student> list = new ArrayList<Student>();
		for (int i = 1; i <= new StudentController().getList().size();i++){
			if(req.getParameter("check"+i) != null){
				stu = new Student();
				stu.setId(Integer.parseInt(req.getParameter("check"+i)));
				list.add(stu);
			}
		}
		c.setListStudent(list);
		
		new ClassController().add(c);
		
		resp.sendRedirect("class");
	}	
}
