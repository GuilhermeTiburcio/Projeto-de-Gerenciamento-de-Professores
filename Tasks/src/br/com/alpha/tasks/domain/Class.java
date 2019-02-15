package br.com.alpha.tasks.domain;

import java.util.Calendar;
import java.util.List;

public class Class implements IDomain {
	private int id;
	private String name;
	private String startDate;
	private String finalDate;
	private String description;
	private List<Student> listStudent;
	private int numberStudent;

	public Class() {
	}

	public Class(int id, String name, String startDate, String finalDate,
			String description, List<Student> listStudent) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.description = description;
		this.listStudent = listStudent;
	}

	public Class(int id, String name, String startDate, String finalDate,
			String description, int number) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.finalDate = finalDate;
		this.description = description;
		this.numberStudent = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(String finalDate) {
		this.finalDate = finalDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public int getNumberStudent() {
		return numberStudent;
	}

	public void setNumberStudent(int numberStudent) {
		this.numberStudent = numberStudent;
	}

}
