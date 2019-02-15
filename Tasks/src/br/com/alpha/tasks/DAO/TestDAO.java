package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alpha.tasks.domain.Class;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Matter;
import br.com.alpha.tasks.domain.Question;
import br.com.alpha.tasks.domain.Test;

public class TestDAO implements IDAO {

	private int idMatter(Matter m){
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbmatter where name_matter = ?";		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getName());
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				return rs.getInt("id_matter");
			}
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		return 0;
	}
	
	private int idClass(Class c){
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbclass where name_class = ?";		
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, c.getName());
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				return rs.getInt("id_class");
			}
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		return 0;
	}
	
	@Override
	public void add(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Insert into tbtest (id_matter,id_class) values (?,?)";
		Test t = (Test) obj;
		int cod = 0;
		try {	
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idMatter(t.getMatter()));
			pstm.setInt(2, idClass(t.getClas()));
			pstm.execute();
			pstm.close();
			
			// Segunda parte
			String sql2 = "Select max(id_test) from tbtest";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			ResultSet rs = pstm2.executeQuery();
			if (rs.next())
				cod = Integer.parseInt(rs.getString(1));
			pstm2.close();
			
			//terceira parte
			
			String sql3 = "Insert into tbquestionfromtest (id_question,id_test) values (?,?)";
			for(Question q : t.getListQuestion()){
				PreparedStatement pstm3 = conn.prepareStatement(sql3);
				pstm3.setInt(1, q.getId());
				pstm3.setInt(2, cod);
				pstm3.execute();
				pstm3.close();
			}
		} catch (Exception ex) {System.out.println(ex.getMessage());}
		finally{
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public void delete(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Delete From tbquestionfromtest where id_test = ?";
		Test t = (Test) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, t.getId());
			pstm.execute();
			pstm.close();
			
			String sql2 = "Delete From tbtest where id_test = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, t.getId());
			pstm2.execute();
			pstm2.close();
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(IDomain obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<IDomain> getList() {
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbtest inner join tbclass on tbtest.id_class = tbclass.id_class inner join tbmatter on tbmatter.id_matter = tbtest.id_matter";		
		List<IDomain> listTest = new ArrayList<IDomain>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				Matter m = new Matter();
				m.setName(rs.getString("name_matter"));
				Class c = new Class();
				c.setName(rs.getString("name_class"));
				Test test = new Test();
				test.setClas(c);
				test.setMatter(m);
				test.setId(rs.getInt("id_test"));
				test.setListQuestion(listQuestion(test.getId()));
				test.setQntQuestions(listQuestionTamanho(test.getId()));
				listTest.add(test);
			}
			return listTest;
		} catch (Exception ex) {}
		finally{
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<Question> listQuestion(int id){
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbquestionfromtest where id_test = ?";
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
	
	private int listQuestionTamanho(int id){
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbquestionfromtest where id_test = ?";
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
			return listQuestion.size();
		} catch (Exception ex) {}
		finally{
			MyConnection.closeConnection(conn);
		}
		return 0;
	}

}
