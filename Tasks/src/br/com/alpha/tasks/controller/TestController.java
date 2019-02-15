package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.TestDAO;
import br.com.alpha.tasks.domain.IDomain;

public class TestController {

	public void add(IDomain obj) {
		new TestDAO().add(obj);
	}
	
	public List<IDomain> getList() {
		return new TestDAO().getList();
	}
	
	public void delete(IDomain obj) {
		new TestDAO().delete(obj);
	}
}
