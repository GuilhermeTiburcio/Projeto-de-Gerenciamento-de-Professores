package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.UserDAO;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.User;

public class UserController {

	public void add(IDomain obj){
		new UserDAO().add(obj);
	}
	public List<IDomain> getList() {
		return new UserDAO().getList();
	}
	public void delete(IDomain obj) {
		new UserDAO().delete(obj);
	}
	public User getElementById(int id) {
		return new UserDAO().getElementById(id);
	}
	public void update(IDomain obj) {
		new UserDAO().update(obj);
	}
	public boolean duplicateRegistration(IDomain obj) {
		return new UserDAO().duplicateRegistration(obj);
	}
}
