package br.com.alpha.tasks.domain;

public class Grade implements IDomain{
	private int id;
	private Matter matter;
	private Class clas;
	private double grade;
	private Student student;
	
	
	public Grade(){}
	
	
	
	public Grade(int id, Matter matter, Class clas, double grade,
			Student student) {
		super();
		this.id = id;
		this.matter = matter;
		this.clas = clas;
		this.grade = grade;
		this.student = student;
	}



	public Matter getMatter() {
		return matter;
	}

	public void setMatter(Matter matter) {
		this.matter = matter;
	}

	public Class getClas() {
		return clas;
	}

	public void setClas(Class clas) {
		this.clas = clas;
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
