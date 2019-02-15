package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.StudentDAO;
import br.com.alpha.tasks.domain.IDomain;

public class StudentController {

	
	public void add(IDomain obj) {
		new StudentDAO().add(obj);
	}
	
	public boolean duplicateRegistration(IDomain obj) {
		return new StudentDAO().duplicateRegistration(obj);
	}
	
	public List<IDomain> getList() {
		return new StudentDAO().getList();
	}
	
	public void delete(IDomain obj) {
		new StudentDAO().delete(obj);
	}
	
	public IDomain getElementById(int id) {
		return new StudentDAO().getElementById(id);
	}
	
	public void update(IDomain obj) {
		new StudentDAO().update(obj);
	}
}
