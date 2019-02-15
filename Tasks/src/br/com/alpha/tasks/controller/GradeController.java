package br.com.alpha.tasks.controller;

import java.util.List;

import br.com.alpha.tasks.DAO.GradesDAO;
import br.com.alpha.tasks.domain.IDomain;

public class GradeController {

	
	public List<IDomain> getList() {
		return new GradesDAO().getList();
	}
}
