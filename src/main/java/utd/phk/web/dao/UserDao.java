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
	
	public User getUserById(String id) {
		return null;
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
				+ "(fname) "
				+ " values(?)";

		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		/*ps.setString(1, newUser.getuName());
		ps.setString(2, newUser.getPassword());
		ps.setString(3, newUser.getfName());*/
		ps.setString(1, newUser.getfName());
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
