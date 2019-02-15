package br.com.alpha.tasks.domain;
import br.com.alpha.tasks.controller.Valid;

public class User implements IDomain{

	private int id;
	private String name;
	private String login;
	private String password;
	private TYPE_USER type;
	
	
	public User() {
	}
	
	public User(String login, String senha){
		this.login = login;
		this.password = senha;
	}
	
	
	public User(int id, String login, String password, String type,String name){
		this.id = id;
		this.login = login;
		this.password = password;
		this.type = Valid.chengeToTypeUser(type);
		this.name = name;
	}
	
	public User(String login, String password, String type){
		this.login = login;
		this.password = password;
		this.type = Valid.chengeToTypeUser(type);
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public TYPE_USER getType() {
		return type;
	}
	public void setType(TYPE_USER type) {
		this.type = type;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}
	
	
}
