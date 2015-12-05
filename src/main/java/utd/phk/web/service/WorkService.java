package utd.phk.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utd.phk.web.dao.WorkDao;
import utd.phk.web.model.User;
import utd.phk.web.model.Work;

@Service
public class WorkService {
	
	@Autowired
	private WorkDao workDao;
	
	public int createWork(String workDescription, String createdBy, String tsExpiry, String startLocation, String endLocation, String cost) {
		int result = -1;
        Work work = new Work();
        User user= new User();
        work.setWorkDescription(workDescription);
        work.setTsExpiry(tsExpiry);
        work.setStartLocation(startLocation);
        work.setEndLocation(endLocation);
        work.setCost(cost);
        user.setUserid(createdBy);
        
        try {
            result = workDao.createWork(work,user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
	

}
