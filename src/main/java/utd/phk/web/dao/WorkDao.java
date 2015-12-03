package utd.phk.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class WorkDao {
	
	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return this.dataSource;
	}

}
