package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import br.com.alpha.tasks.domain.Alternatives;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Question;
import br.com.alpha.tasks.domain.User;

public class QuestionDAO implements IDAO {
	private Question question;
	private Alternatives alternatives;

	@Override
	public void add(IDomain obj) {
		int cod = 0;
		alternatives = new Alternatives();
		Connection conn = MyConnection.getConnection();
		String sql = "Insert into tbquestion (statement,level,theme,id_matter) values (?,?,?,?)";
		Question qs = (Question) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, qs.getStatement());
			pstm.setInt(2, qs.getLevel());
			pstm.setString(3, qs.getTheme());
			pstm.setInt(4, returnMatter(qs.getDiscipline()));
			pstm.execute();
			pstm.close();
			// Segunda parte
			String sql2 = "Select max(id_question) from tbquestion";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			ResultSet rs = pstm2.executeQuery();
			if (rs.next())
				cod = Integer.parseInt(rs.getString(1));
			pstm2.close();
			for (Alternatives a : qs.getAlternatives()) {
				String sql3 = "Insert into tbalternative (text_alternative,state,id_question) values (?,?,?)";
				PreparedStatement pstm3 = conn.prepareStatement(sql3);
				pstm3.setString(1, a.getText());
				if (a.isChecked())
					pstm3.setInt(2, 1);
				else
					pstm3.setInt(2, 0);
				pstm3.setInt(3, cod);
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
		String sql = "Delete From tbalternative where id_question = ?";
		Question q = (Question) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, q.getId());
			pstm.execute();
			pstm.close();
			String sql2 = "Delete From tbquestion where id_question = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, q.getId());
			pstm2.execute();
			pstm2.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Delete from tbalternative where id_question = ?";
		Question qs = (Question) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, qs.getId());
			pstm.execute();
			pstm.close();
			String sql2 = "Update tbquestion SET statement = ?, level = ?, theme = ?,id_matter = ? where id_question = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setString(1, qs.getStatement());
			pstm2.setInt(2, qs.getLevel());
			pstm2.setString(3, qs.getTheme());
			pstm2.setInt(4, returnMatter(qs.getDiscipline()));
			pstm2.setInt(5, qs.getId());
			pstm2.execute();
			pstm2.close();
			for (Alternatives a : qs.getAlternatives()) {
				String sql3 = "Insert into tbalternative (text_alternative,state,id_question) values (?,?,?)";
				PreparedStatement pstm3 = conn.prepareStatement(sql3);
				pstm3.setString(1, a.getText());
				if (a.isChecked())
					pstm3.setInt(2, 1);
				else
					pstm3.setInt(2, 0);
				pstm3.setInt(3, qs.getId());
				pstm3.execute();
				pstm3.close();
			}
			conn.close();
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public List<IDomain> getList() {
		List<IDomain> list = new ArrayList<IDomain>();
		Connection conn = MyConnection.getConnection();
		String sql = "Select * from tbquestion order by statement";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new Question(rs.getInt("id_question"), rs
						.getString("statement"), rs.getInt("level"), rs
						.getString("theme"), returnNameMatter(rs
						.getInt("id_matter"))));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IDomain getElementById(int id) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select text_alternative,state From tbalternative where id_question = ?";
		question = new Question();
		List<Alternatives> list = new ArrayList<Alternatives>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				alternatives = new Alternatives();
				alternatives.setText(rs.getString("text_alternative"));
				if (rs.getInt("state") == 0)
					alternatives.setChecked(false);
				else
					alternatives.setChecked(true);
				list.add(alternatives);
			}
			question.setAlternatives(list);
			pstm.close();
			rs.close();
			String sql2 = "Select id_question,statement,level,theme,id_matter From tbquestion where id_question = ?";
			PreparedStatement pstm2 = conn.prepareStatement(sql2);
			pstm2.setInt(1, id);
			ResultSet rs2 = pstm2.executeQuery();
			while (rs2.next()) {
				question.setStatement(rs2.getString("statement"));
				question.setLevel(rs2.getInt("level"));
				question.setTheme(rs2.getString("theme"));
				question.setDiscipline(returnNameMatter(rs2.getInt("id_matter")));
				question.setId(rs2.getInt("id_question"));
			}
			conn.close();
			return question;
		} catch (Exception ex) {
			System.out.println(ex);
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	public int returnMatter(String name) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select id_matter From tbmatter where name_matter = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getInt("id_matter");
			}
			pstm.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return 0;
	}

	public String returnNameMatter(int id) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select name_matter From tbmatter where id_matter = ?";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				return rs.getString("name_matter");
			}
			pstm.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	public List<IDomain> getListOfMatter(int id) {
		List<IDomain> list = new ArrayList<IDomain>();
		Connection conn = MyConnection.getConnection();
		String sql = "Select * from tbquestion where id_matter = ? order by statement";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new Question(rs.getInt("id_question"), rs
						.getString("statement"), rs.getInt("level"), rs
						.getString("theme"), returnNameMatter(rs
						.getInt("id_matter"))));
			}
			return list;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}
}
