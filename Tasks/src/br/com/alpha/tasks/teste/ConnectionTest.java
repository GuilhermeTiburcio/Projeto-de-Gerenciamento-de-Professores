package br.com.alpha.tasks.teste;

import java.sql.Connection;

import br.com.alpha.tasks.DAO.MyConnection;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection con = MyConnection.getConnection();
		if(con != null){
			System.out.println("Conectou");
		}else{
			System.out.println("Erro");
		}
	}
}
