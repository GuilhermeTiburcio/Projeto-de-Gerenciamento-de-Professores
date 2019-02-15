package br.com.alpha.tasks.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import br.com.alpha.tasks.controller.Valid;
import br.com.alpha.tasks.domain.IDomain;
import br.com.alpha.tasks.domain.TYPE_USER;
import br.com.alpha.tasks.domain.User;

public class UserDAO implements IDAO {
	private User u = null;

	@Override
	public void add(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "Insert into tbuser (login,password,type_user,name) values (?,?,?,?)";
		User user = (User) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getLogin());
			pstm.setString(2, user.getPassword());
			pstm.setString(3, user.getType().toString());
			pstm.setString(4, user.getName());
			pstm.execute();
			pstm.close();
		} catch (Exception ex) {
			System.out.println(ex);
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
			if (u.getType().equals(TYPE_USER.STUDENT)) {
				String sql2 = "Delete From tbstudent where id_user = ?";
				PreparedStatement pstm2 = conn.prepareStatement(sql2);
				pstm2.setInt(1, u.getId());
				pstm2.execute();
				pstm2.close();
				PreparedStatement pstm3 = conn.prepareStatement(sql);
				pstm3.setInt(1, u.getId());
				pstm3.executeUpdate();
				pstm3.close();
			} else {
				PreparedStatement pstm = conn.prepareStatement(sql);
				pstm.setInt(1, u.getId());
				pstm.executeUpdate();
				pstm.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public void update(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "UPDATE tbuser SET login = ?, password = ?, type_user = ?,name = ? where id = ?";
		User u = (User) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, u.getLogin());
			pstm.setString(2, u.getPassword());
			pstm.setString(3, u.getType().toString());
			pstm.setString(4, u.getName());
			pstm.setInt(5, u.getId());
			pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
		} finally {
			MyConnection.closeConnection(conn);
		}
	}

	@Override
	public List<IDomain> getList() {
		List<IDomain> lista = new ArrayList<IDomain>();
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbuser where type_user = ? order by login";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, TYPE_USER.PROFESSOR.toString());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lista.add(new User(rs.getInt("id"), rs.getString("login"), rs
						.getString("password"), rs.getString("type_user"),rs.getString("name")));
			}
			return lista;
		} catch (Exception ex) {
			System.out.println(ex);
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
	public User getElementById(int id) {
		Connection conn = MyConnection.getConnection();
		String sql = "Select * From tbuser where id = ?";
		u = new User();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				u.setId(id);
				u.setName(rs.getString("name"));
				u.setLogin(rs.getString("login"));
				u.setPassword(rs.getString("password"));
				u.setType(Valid.chengeToTypeUser(rs.getString("type_user")));
				return u;
			}
		} catch (Exception e) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return u;
	}

	@Override
	public boolean duplicateRegistration(IDomain obj) {
		Connection conn = MyConnection.getConnection();
		String sql = "select * from tbuser where login = ?";
		User user = (User) obj;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getLogin());
			ResultSet rs = pstm.executeQuery();
			return (rs.next()) ? true : false;
		} catch (Exception ex) {
		} finally {
			MyConnection.closeConnection(conn);
		}
		return false;
	}
}
