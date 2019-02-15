package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alpha.tasks.domain.Class;
import br.com.alpha.tasks.domain.Grade;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Matter;
import br.com.alpha.tasks.domain.Student;

public class GradesDAO implements IDAO {

	@Override
	public void add(IDomain obj) {

		// TODO Auto-generated method stub

	}

	@Override
	public void delete(IDomain obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IDomain obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IDomain> getList() {
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbteststudent inner join tbtest on tbtest.id_test = tbteststudent.id_test inner join tbstudent on tbstudent.id_student = tbteststudent.id_student inner join tbuser on tbuser.id = tbstudent.id_user inner join tbmatter on tbmatter.id_matter = tbtest.id_matter inner join tbclass on tbclass.id_class = tbtest.id_class";
		List<IDomain> list = new ArrayList<IDomain>();
		Student s = null;
		Class c = null;
		Matter m = null;
		Grade g = null;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setName(rs.getString("name"));
				c = new Class();
				c.setName(rs.getString("name_class"));
				m = new Matter();
				m.setName(rs.getString("name_matter"));
				g = new Grade();
				g.setId(rs.getInt("id_teststudent"));
				g.setClas(c);
				g.setMatter(m);
				g.setStudent(s);
				g.setGrade(rs.getDouble("final_grade"));
				list.add(g);
			}
			return list;
		} catch (Exception ex) {
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
