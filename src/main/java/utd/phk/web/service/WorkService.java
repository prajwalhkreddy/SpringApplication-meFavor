package utd.phk.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utd.phk.web.dao.WorkDao;
import utd.phk.web.model.Work;

@Service
public class WorkService {
	
	@Autowired
	private WorkDao workDao;
	
	public boolean createWork(String workDescription, String tsCompleted, String startLocation, String endLocation, String cost) {
		boolean result = false;
        Work work = new Work();
        work.setWorkDescription(workDescription);
        work.setTsCompleted(tsCompleted);
        work.setStartLocation(startLocation);
        work.setEndLocation(endLocation);
        work.setCost(cost);
        
        try {
            result = workDao.createWork(work);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
	

}
