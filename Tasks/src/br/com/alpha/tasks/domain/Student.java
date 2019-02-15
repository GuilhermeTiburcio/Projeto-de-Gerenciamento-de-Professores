package br.com.alpha.tasks.domain;

public class Student extends User {
	private int id;
	private int ra;
	private String name;
	private String login;
	private int id_user;
	
	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
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

	public Student() {
	}

	public Student(int id, String name, int ra,String login,int id_user) {
		this.id = id;
		this.name = name;
		this.ra = ra;
		this.login = login;
		this.id_user = id_user;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

}
