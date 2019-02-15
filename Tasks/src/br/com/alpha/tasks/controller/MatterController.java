package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.MatterDAO;
import br.com.alpha.tasks.domain.IDomain;

public class MatterController {

	public void add(IDomain obj) {
		new MatterDAO().add(obj);
	}

	public void delete(IDomain obj) {
		new MatterDAO().delete(obj);
	}

	public void update(IDomain obj) {
		new MatterDAO().update(obj);
	}

	public List<IDomain> getList() {
		return new MatterDAO().getList();
	}

	public IDomain getElementById(int id) {
		return new MatterDAO().getElementById(id);
	}
	
	public boolean duplicateRegistration(IDomain obj) {
		return new MatterDAO().duplicateRegistration(obj);
	}
	
	public IDomain getElementByName(String name) {
		return new MatterDAO().getElementByName(name);
	}
}
