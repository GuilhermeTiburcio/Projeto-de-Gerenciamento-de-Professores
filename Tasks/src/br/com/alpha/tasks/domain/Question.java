package br.com.alpha.tasks.domain;

import java.util.List;


public class Question implements IDomain{
	private String statement;
	private int level;
	private String theme;
	private String discipline;
	private List<Alternatives> alternatives;
	private int id;
	
	public Question(){}
	
	public Question(int id,String statement, int level, String theme, String discipline) {
		super();
		this.id = id;
		this.statement = statement;
		this.level = level;
		this.theme = theme;
		this.discipline = discipline;
	}
	
	public List<Alternatives> getAlternatives() {
		return alternatives;
	}
	public void setAlternatives(List<Alternatives> alternatives) {
		this.alternatives = alternatives;
	}
	
	public String getStatement() {
		return statement;
	}
	public void setStatement(String statement) {
		this.statement = statement;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getDiscipline() {
		return discipline;
	}
	public void setDiscipline(String discipline) {
		this.discipline = discipline;
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
