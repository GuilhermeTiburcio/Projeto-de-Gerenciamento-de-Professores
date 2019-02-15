package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.LoginDAO;
import br.com.alpha.tasks.domain.Question;
import br.com.alpha.tasks.domain.Student;
import br.com.alpha.tasks.domain.Test;
import br.com.alpha.tasks.domain.User;

public class LoginController {

	public static User login(String login, String password){
		User user = null;
		return user = LoginDAO.login(new User(login, password));
	}
	public Student pegaStudent(int id){
		return new LoginDAO().pegaStudent(id);
	}
	
	public List<Test> testStudent(int id) {
		return new LoginDAO().testStudent(id);
	}
	
	public List<Question> idQuestion(int id){
		return new LoginDAO().idQuestion(id);
	}
	
	public void TestStudentFinal(int id_student,int id_test,int certain,int wrong, double final_grade){
		new LoginDAO().TestStudentFinal(id_student, id_test, certain, wrong, final_grade);
	}
	
	public boolean pesquisaProva(int id_test, int id_student){
		return new LoginDAO().pesquisaProva(id_test, id_student);
	}
}
