package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Student;
import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;

public class StudentDAO implements IDAO {

	@Override
	public void add(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Insert into tbuser (login,password,type_user,name) values (?,?,?,?)";
		Student s = (Student) obj;
		int cod = 0;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLogin());
			pstm.setString(2, s.getPassword());
			pstm.setString(3, TYPE_USER.STUDENT.toString());
			pstm.setString(4, s.getName());
			pstm.execute();
			pstm.close();
			// Pegando o id do usuario

			String sql2 = "Select max(id) from tbuser";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			ResultSet rs = pstm2.executeQuery();
			if (rs.next())
				cod = rs.getInt(1);
			pstm2.close();
			rs.close();
			// Cadastrando na tabela estudante

			String sql3 = "insert into tbstudent (ra,id_user) values (?,?)";
			PreparedStatement pstm3 = conn.prepareStatement(sql3);
			pstm3.setInt(1, s.getRa());
			pstm3.setInt(2, cod);
			pstm3.execute();
			pstm3.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public void delete(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Delete From tbuser where id = ?";
		User u = (User) obj;
		try {
			String sql2 = "Delete From tbstudent where id_user = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, u.getId());
			pstm2.execute();
			pstm2.close();
			PreparedStatement pstm3 = conn.prepareStatement(sql);
			pstm3.setInt(1, u.getId());
			pstm3.executeUpdate();
			pstm3.close();
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}

	}

	@Override
	public void update(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Update tbuser SET login = ?,password = ?,type_user = ?, name = ? where id = ?";
		Student s = (Student) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, s.getLogin());
			pstm.setString(2, s.getPassword());
			pstm.setString(3, s.getType().toString());
			pstm.setString(4, s.getName());
			pstm.setInt(5, s.getId());
			pstm.executeUpdate();
			pstm.close();
			String sql2 = "Update tbstudent SET ra = ? where id_user = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, s.getRa());
			pstm2.setInt(2, s.getId());
			pstm2.executeUpdate();
			pstm2.close();
		} catch (Exception ex) {System.out.println("ih "+ex.getMessage());}	
		finally{
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public List<IDomain> getList() {
		List<IDomain> lista = new ArrayList<IDomain>();
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbuser inner join tbstudent on tbuser.id = tbstudent.id_user order by name";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new Student(rs.getInt("id_student"), rs.getString("name"),rs.getInt("ra"),rs.getString("login"),rs.getInt("id_user")));
			}
			return lista;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	@Override
	public List<IDomain> getListById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IDomain getElementById(int id) {
		Connection conn = MyConnection.getConnection();
		Student student = null;
		
		String sql = "Select * From tbuser inner join tbstudent on tbstudent.id_user = tbuser.id where id = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				student = new Student();
				student.setName(rs.getString("name"));
				student.setLogin(rs.getString("login"));
				student.setPassword(rs.getString("password"));
				student.setRa(rs.getInt("ra"));
				student.setId(id);
			}
			return student;
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select ra From tbstudent where ra = ?";
		Student s = (Student) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, s.getRa());
			ResultSet rs = pstm.executeQuery();
			if (rs.next())
				return false;
		} catch (Exception ex) {
			System.err.println(ex);
		} finally {

		}
		return true;
	}

}
