package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.Matter;

public class MatterDAO implements IDAO {

	@Override
	public void add(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "insert into tbmatter (name_matter) values (?)";
		Matter m = (Matter) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getName());
			pstm.execute();
			pstm.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Delete From tbmatter where id_matter = ?";
		Matter m = (Matter) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, m.getId());
			pstm.execute();
			pstm.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Update tbmatter Set name_matter = ? where id_matter = ?";
		Matter m = (Matter) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getName());
			pstm.setInt(2, m.getId());
			pstm.execute();
			pstm.close();
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub

	}

	@Override
	public List<IDomain> getList() {
		List<IDomain> list = new ArrayList<IDomain>();
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbmatter order by name_matter";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				list.add(new Matter(rs.getString("name_matter"), rs
						.getInt("id_matter")));
			}
			return list;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		// TODO Auto-generated method stub
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
		String sql = "Select * From tbmatter where id_matter = ?";
		Matter m = new Matter();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				m.setId(id);
				m.setName(rs.getString("name_matter"));
			}
			return m;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbmatter where name_matter = ?";
		Matter m = (Matter) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, m.getName());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) 
				return false;
			else
				return true;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return true;
	}

	public IDomain getElementByName(String name) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbmatter where name_matter = ?";
		Matter m = new Matter();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, name);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				m.setId(rs.getInt("id_matter"));
				m.setName(name);
			}
			return m;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return null;
	}
	
}
