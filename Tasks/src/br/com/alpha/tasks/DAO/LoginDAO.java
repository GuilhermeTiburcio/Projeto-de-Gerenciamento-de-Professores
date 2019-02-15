package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alpha.tasks.controller.Valid;
import br.com.alpha.tasks.domain.Class;
import br.com.alpha.tasks.domain.Matter;
import br.com.alpha.tasks.domain.Question;
import br.com.alpha.tasks.domain.Student;
import br.com.alpha.tasks.domain.Test;
import br.com.alpha.tasks.domain.User;

public class LoginDAO {

	public static User login(User u) {
		User user = null;
		Connection con = MyConnection.getConnection();

		String sql = "select * from tbuser where login like ? and password like ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, u.getLogin());
			ps.setString(2, u.getPassword());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();

				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setPassword(rs.getString("password"));
				user.setType(Valid.chengeToTypeUser(rs.getString("type_user")));
			}
			return user;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			MyConnection.closeConnection(con);
		}
		return null;
	}

	public Student pegaStudent(int id) {
		Connection conn = MyConnection.getConnection();
		Student s = new Student();
		String sql = "Select * From tbstudent where id_user = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt("id_student"));
			}
			return s;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	public List<Test> testStudent(int id) {
		Connection conn = MyConnection.getConnection();
		Test t = null;
		List<Test> listTest = new ArrayList<Test>();
		String sql = "select * From tbstudent inner join tbcomponentclass on tbstudent.id_student = tbcomponentclass.id_student inner join tbclass on tbclass.id_class = tbcomponentclass.id_class inner join tbtest on tbtest.id_class = tbclass.id_class inner join tbmatter on tbmatter.id_matter = tbtest.id_matter where tbstudent.id_student = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				t = new Test();
				t.setId(rs.getInt("id_test"));
				Class c = new Class();
				c.setName(rs.getString("name_class"));
				t.setClas(c);
				Matter m = new Matter();
				m.setName(rs.getString("name_matter"));
				t.setMatter(m);
				listTest.add(t);
			}
			return listTest;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}

		return null;
	}
	
	public List<Question> idQuestion(int id){
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbquestionfromtest where id_test = ?";
		List<Question> listQuestion = new ArrayList<Question>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Question q = new Question();
				q.setId(rs.getInt("id_question"));
				listQuestion.add(q);
			}
			return listQuestion;
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		return null;
	}
	
	public void TestStudentFinal(int id_student,int id_test,int certain,int wrong, double final_grade){
		Connection conn = MyConnection.getConnection();
		String sql = "Insert into tbteststudent (id_student,id_test,certain,wrong,final_grade) values (?,?,?,?,?)";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_student);
			pstm.setInt(2, id_test);
			pstm.setInt(3, certain);
			pstm.setInt(4, wrong);
			pstm.setDouble(5, final_grade);
			pstm.execute();
			pstm.close();
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
	}
	
	public boolean pesquisaProva(int id_test, int id_student){
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbteststudent where id_student = ? and id_test = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_student);
			pstm.setInt(2, id_test);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				return false;
			}
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		return true;
	}
}
