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
		User user = null;
		try {
			user = userDao.getUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
							
		//List<String> users = getOpponentDaoImpl().getOpponents(id);
				
		System.out.println("getting");
		return user;
	}
	
	public boolean newUser(String fName, String lName, String address, String zipcode, String gender, String phnumber, String username, String password) {
		boolean result = false;
        User user = new User();
        user.setfName(fName);
        user.setlName(lName);
        user.setAddress(address);
        user.setZipcode(zipcode);
        user.setGender(gender);
        user.setPhnumber(phnumber);
        user.setuName(username);
        user.setPassword(password);
        
        try {
            result = userDao.createUser(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
	
	public boolean userLogin(String username, String password) {
		boolean result = false;
        User user = new User();
        user.setuName(username);
        user.setPassword(password);
        try {
            result = userDao.loginDao(user);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
	}
}
