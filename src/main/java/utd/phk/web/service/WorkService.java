package utd.phk.web.service;

import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.spy.memcached.MemcachedClient;
import utd.phk.web.dao.WorkDao;
import utd.phk.web.model.OpenWorks;
import utd.phk.web.model.User;
import utd.phk.web.model.Work;

@Service
public class WorkService {

	@Autowired
	private WorkDao workDao;

	public int createWork(String workDescription, String createdBy, String tsExpiry, String startLocation,
			String endLocation, String cost) {
		int result = -1;
		Work work = new Work();
		User user = new User();
		work.setWorkDescription(workDescription);
		work.setTsExpiry(tsExpiry);
		work.setStartLocation(startLocation);
		work.setEndLocation(endLocation);
		work.setCost(cost);
		user.setUserid(createdBy);

		try {
			result = workDao.createWork(work, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// Get Work Information
	// caching done here
	@SuppressWarnings("unchecked")
	public List<OpenWorks> getWork(String compstatus) {
		List<OpenWorks> openWorks=null;
		MemcachedClient client = null;
		Object cacheObj = null;
		String comp1;
		try {
			comp1 = ""+WorkStatus.values()[(Integer.parseInt(compstatus))];
			client = getClient();
			// check if present in cache
			if (client != null) {
				 cacheObj = client.get(comp1);
				 if (cacheObj == null) {
					 System.out.println("cache miss, fecthing from db...");
					 openWorks = workDao.getOpenWorks(compstatus);
					 client.set(comp1, 60, openWorks);
					 System.out.println("storing result in cache...");
				 } else {
					 System.out.println("cache hit, serving data from cache");
					 openWorks =  (List<OpenWorks>) cacheObj;
				 }
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Getting List of Open Works from Database");
		return openWorks;
	}
	
	
	//Update Work
	public int updateWork(String workid, String acceptorid, String compstatus) {
		int result = -1;
		Work work = new Work();
		work.setWorkId(workid);
		work.setAssignTo(acceptorid);;

		try {
			result = workDao.updateWork(work,compstatus);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	private MemcachedClient getClient(){
		String configEndpoint = "localhost";
		Integer clusterPort = 11211;
		MemcachedClient client = null;
		
		if(client == null) {
			try {
				client = new MemcachedClient(new InetSocketAddress(configEndpoint,
						clusterPort));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return client;
	}

}
