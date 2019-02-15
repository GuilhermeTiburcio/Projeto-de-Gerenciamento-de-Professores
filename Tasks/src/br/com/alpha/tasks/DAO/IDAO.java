package br.com.alpha.tasks.DAO;

import java.util.List;

import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.User;

public interface IDAO {

	public void add(IDomain obj);
	public void delete(IDomain obj);
	public void update(IDomain obj);
	public List<IDomain> getList();
	public List<IDomain> getListById(int id);
	public IDomain getElementById(int id);
	public boolean duplicateRegistration(IDomain obj);
}
