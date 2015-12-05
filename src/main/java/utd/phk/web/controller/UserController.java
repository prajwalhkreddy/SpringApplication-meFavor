package utd.phk.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import utd.phk.web.model.User;
import utd.phk.web.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/login")
	public String login() {
		String message = "Login page was supposed to be here!";
		return message;
	}

	//Retrieve User Details 
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET) ///user GET -> list of users
	// @ResponseBody List<User>
	public @ResponseBody ResponseEntity<User> getUser(@PathVariable("id") String userid, HttpServletResponse response) {
		ResponseEntity<User> userdetails = null;
		User user = userService.getUser(userid);
		if (user == null) {
			response.setStatus(404);
			return userdetails;
		}
		userdetails = new ResponseEntity<User>(user, HttpStatus.OK);
		return userdetails;
	}

	/// user?name="Prajwal"
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@RequestParam("ids") String ids) {
		return null;//1,2,3,4 // [] -> dao -> for
	}


	
	//Signup Page
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public @ResponseBody boolean createUser(@RequestParam("fname") String fName, @RequestParam("lname") String lName, @RequestParam("address") String address, @RequestParam("zipcode") String zipcode, @RequestParam("gender") String gender,  @RequestParam("phnumber") String phnumber,  @RequestParam("username") String username,  @RequestParam("password") String password) {
        String result = "success";    
        System.out.println("success");
        boolean status = userService.newUser(fName, lName, address, zipcode, gender, phnumber, username, password);

        return status;
    }
	
	//Login Check
	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public @ResponseBody String createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        String result = "Login Success";    
        System.out.println(result);
        String status = userService.userLogin(username,password);

        return status;
    }
}
