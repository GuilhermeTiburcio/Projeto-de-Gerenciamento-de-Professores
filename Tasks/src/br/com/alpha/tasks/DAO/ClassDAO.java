package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alpha.tasks.controller.Valid;
import br.com.alpha.tasks.domain.Class;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Student;

public class ClassDAO implements IDAO {
	private Class c;

	private int studentsClass(int id){
		Connection conn = MyConnection.getConnection();
		String sql = "select * From tbcomponentclass inner join tbstudent on tbcomponentclass.id_student = tbstudent.id_student inner join tbuser on tbuser.id = tbstudent.id_user where id_class = ?";
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				list.add(new Student(rs.getInt("id_student"),rs.getString("name"),rs.getInt("ra"),rs.getString("login"),rs.getInt("id_user")));
			}
			return list.size();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return 0;
	}
	
	private List<Student> listStudentsClass(int id){
		Connection conn = MyConnection.getConnection();
		String sql = "select * From tbcomponentclass inner join tbstudent on tbcomponentclass.id_student = tbstudent.id_student inner join tbuser on tbuser.id = tbstudent.id_user where id_class = ?";
		List<Student> list = new ArrayList<Student>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				list.add(new Student(rs.getInt("id_student"),rs.getString("name"),rs.getInt("ra"),rs.getString("login"),rs.getInt("id_user")));
			}
			return list;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}
	
	@Override
	public void add(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "insert into tbclass (name_class,description_class,start_date,final_date) values (?,?,?,?)";
		c = (Class) obj;
		int cod = 0;
		try {
			// Cadastrando a classe
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getName());
			pstm.setString(2, c.getDescription());
			pstm.setString(3, c.getStartDate());
			pstm.setString(4, c.getFinalDate());
			pstm.execute();
			pstm.close();
			// Pegando o codigo da classe
			String sql2 = "Select max(id_class) from tbclass";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			ResultSet rs = pstm2.executeQuery();
			if (rs.next())
				cod = Integer.parseInt(rs.getString(1));
			pstm2.close();
			rs.close();
			// Cadastrando os alunos
			for (Student s : c.getListStudent()) {
				String sql3 = "Insert into tbcomponentclass (id_student,id_class) values (?,?)";
				PreparedStatement pstm3 = conn.prepareStatement(sql3);
				pstm3.setInt(1, s.getId());
				pstm3.setInt(2, cod);
				pstm3.execute();
				pstm3.close();
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public void delete(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Delete From tbcomponentclass where id_class = ?";
		Class c = (Class) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, c.getId());
			pstm.execute();
			pstm.close();
			String sql2 = "Delete From tbclass where id_class = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, c.getId());
			pstm2.execute();
			pstm2.close();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}

	}

	@Override
	public void update(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}

	}

	@Override
	public List<IDomain> getList() {
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbclass";
		List<IDomain> list = new ArrayList<IDomain>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				list.add(new Class(rs.getInt("id_class"),rs.getString("name_class"),Valid.dataReversal(rs.getString("start_date")),Valid.dataReversal(rs.getString("final_date")),rs.getString("description_class"),studentsClass(rs.getInt("id_class"))));
			}
			return list;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	@Override
	public List<IDomain> getListById(int id) {
		Connection conn = MyConnection.getConnection();
		String sql = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	@Override
	public IDomain getElementById(int id) {
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbclass where id_class = ?";
		Class c = new Class();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				c.setId(id);
				c.setName(rs.getString("name_class"));
				c.setStartDate(Valid.dataReversal(rs.getString("start_date")));
				c.setFinalDate(Valid.dataReversal(rs.getString("final_date")));
				c.setDescription(rs.getString("description_class"));
				c.setListStudent(listStudentsClass(rs.getInt("id_class")));
			}
			return c;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return false;
	}

}
