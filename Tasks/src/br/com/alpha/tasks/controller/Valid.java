package br.com.alpha.tasks.controller;

import br.com.alpha.tasks.domain.TYPE_USER;

public class Valid {
	
	public static TYPE_USER chengeToTypeUser(String type){
		if(type.equalsIgnoreCase(TYPE_USER.PROFESSOR.toString())){
			return TYPE_USER.PROFESSOR;
		}else if(type.equalsIgnoreCase(TYPE_USER.STUDENT.toString())){
			return TYPE_USER.STUDENT;
		}
		return null;
	}
	public static boolean validFields(String login, String password){
		return (!login.equals("") && !password.equals(""));
	}
	
	public static String data(String data){
		String dia = data.substring(0, 2);
		String mes = data.substring(3, 5);
		String ano = data.substring(6, 10);
		return ano+"/"+mes+"/"+dia;
	}
	
	public static String dataReversal(String data){
		String dia = data.substring(8, 10);
		String mes = data.substring(5, 7);
		String ano = data.substring(0, 4);
		return dia+"/"+mes+"/"+ano;
	}
}
