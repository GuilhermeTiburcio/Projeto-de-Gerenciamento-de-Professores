package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	
	public static Connection getConnection(){
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/bdtask";
		String user = "postgres";
		String pass = "123";
		
		try {
			Class.forName("org.postgresql.Driver");

			con = DriverManager.getConnection(url,user,pass);
			
			return con;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static void closeConnection(Connection conn){
		try{
			conn.close();
		}catch(Exception e){
			System.out.println("Erro ao fechar");
		}
	}
}
