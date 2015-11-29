package utd.phk.web.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utd.phk.web.dao.UserDao;
import utd.phk.web.model.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User getUser(String id) {
		//query db
		User u = new User();
//		u.setId("1");
//		u.setFirstName("Prajwal");
		return u;
	}
	
	public int newUser(String name) {
		int result = -1;
        User user = new User();
        user.setfName(name);
        try {
            result = userDao.createUser(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
}
