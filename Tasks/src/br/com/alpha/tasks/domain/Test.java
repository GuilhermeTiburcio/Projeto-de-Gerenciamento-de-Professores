package br.com.alpha.tasks.domain;

import java.util.List;

public class Test implements IDomain{
	private int id;
	private List<Question> listQuestion;
	private Class clas;
	private Matter matter;
	private int qntQuestions;
	
	public int getQntQuestions() {
		return qntQuestions;
	}

	public void setQntQuestions(int qntQuestions) {
		this.qntQuestions = qntQuestions;
	}

	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}

	public Test(){}
		
	public Test(int id, List<Question> listQuestion, Class clas,Matter matter) {
		super();
		this.id = id;
		this.listQuestion = listQuestion;
		this.clas = clas;
		this.matter = matter;
	}
	
	public Test(int id, List<Question> listQuestion, Class clas,Matter matter, int qntQuestions) {
		super();
		this.id = id;
		this.listQuestion = listQuestion;
		this.clas = clas;
		this.matter = matter;
		this.qntQuestions = qntQuestions;
	}

	public List<Question> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<Question> listQuestion) {
		this.listQuestion = listQuestion;
	}

	public Class getClas() {
		return clas;
	}

	public void setClas(Class clas) {
		this.clas = clas;
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
