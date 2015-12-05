package utd.phk.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import utd.phk.web.model.User;
import utd.phk.web.model.Work;

public class WorkDao {

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}
	
	
	//Add new work
	public int createWork(Work newWork, User user) throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		int insert = 0;
		int result = -1;
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
		
		String sql = "insert into meFavorDB.work"
				+ "(work_desc, created_by, assign_status, ts_created, ts_expiry, comp_status, start_location, end_location, cost)"
				+ " values(?,?,?,?,?,?,?,?,?)";
		conn = getDataSource().getConnection();

		ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		ps.setString(1, newWork.getWorkDescription() );
		ps.setString(2, user.getUserid());
		ps.setString(3, ""+0);
		ps.setDate(4, sqlDate);
		ps.setString(5, newWork.getTsExpiry());
		ps.setString(6, ""+0);
		ps.setString(7, newWork.getStartLocation());
		ps.setString(8, newWork.getEndLocation());
		ps.setString(9, newWork.getCost());
		
		insert = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		int rowid = 0;
		if (rs.next()) {
			System.out.println(rs.toString());
			rowid = rs.getInt(1);
			result = 1;
			try {
				ps.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}
	
	
	//Get List of Open Works
	public List<Work> getOpenWorks() throws SQLException {

		Connection conn = null;
		PreparedStatement ps = null;
		List<Work> openworks = new ArrayList<Work>();
		String sql = "SELECT work_desc, created_by, ts_created, ts_expiry, start_location, end_location, cost FROM meFavorDB.work where comp_status=0;";
		conn = getDataSource().getConnection();
		ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		Work work=null;
		while (rs.next()) {
			work =new Work();
			work.setWorkDescription(rs.getString("work_desc"));
			work.setCreatedBy(rs.getString("created_by"));
			work.setTsCreated(rs.getString("ts_created"));
			work.setTsExpiry(rs.getString("ts_expiry"));
			work.setStartLocation(rs.getString("start_location"));
			work.setEndLocation(rs.getString("end_location"));
			work.setCost(rs.getString("cost"));
		
			openworks.add(work);
		}
		return openworks;
	}

}
