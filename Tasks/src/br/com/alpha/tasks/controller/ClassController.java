package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.ClassDAO;
import br.com.alpha.tasks.domain.IDomain;

public class ClassController {

	
	public void add(IDomain obj) {
		new ClassDAO().add(obj);
	}
	
	public List<IDomain> getList() {
		return new ClassDAO().getList();
	}
	
	public void delete(IDomain obj) {
		new ClassDAO().delete(obj);
	}
	
	public IDomain getElementById(int id) {
		return new ClassDAO().getElementById(id);
	}
}
