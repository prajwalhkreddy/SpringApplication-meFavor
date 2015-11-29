package utd.phk.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import utd.phk.web.model.User;

public class UserDao {
	
	@Autowired
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return this.dataSource;
	}
	
	public User getUserById(String id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "select * from mefavordb.users where user_id = ?";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		User user = null;

		if (rs.next()) {
			user = new User();
			user.setUserid(rs.getString("user_id"));
			user.setfName(rs.getString("fname"));
			user.setlName(rs.getString("lname"));
			user.setAddress(rs.getString("address"));
			user.setZipcode(rs.getString("zipcode"));
			user.setGender(rs.getString("gender"));
					
		}
		try {
			ps.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	}

	public User getUserByUserName(String userName) {
		return null;
	}

	public List<User> getUsers() {
		return null;
	}

	public int createUser(User newUser) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;

		String sql = "insert into mefavordb.users"
				+ "(fname, lname, address, zipcode, rating, gender)"
				+ " values(?,?,?,?,?,?)";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, newUser.getfName());
		ps.setString(2, newUser.getlName());
		ps.setString(3, newUser.getAddress());
		ps.setString(4, newUser.getZipcode());
		ps.setString(5, newUser.getRating());
		ps.setString(6, newUser.getGender());
		// set others
		insert = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
		}
		try {
			ps.close();
			conn.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowid;
	}

	public int updateUser(User user) {
		int result = -1;

		return result;
	}

}
