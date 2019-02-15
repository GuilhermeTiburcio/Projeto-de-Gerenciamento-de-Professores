package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.QuestionDAO;
import br.com.alpha.tasks.domain.IDomain;

public class QuestionController {

	public static void add(IDomain obj) {
		new QuestionDAO().add(obj);
	}
	
	public static List<IDomain> getList() {
		return new QuestionDAO().getList();
	}
	public static void delete(IDomain obj) {
		new QuestionDAO().delete(obj);
	}
	
	public static IDomain getElementById(int id) {
		return new QuestionDAO().getElementById(id);
	}
	
	public static void update(IDomain obj) {
		new QuestionDAO().update(obj);
	}
	
	public List<IDomain> getListOfMatter(int id) {
		return new QuestionDAO().getListOfMatter(id);
	}
}
