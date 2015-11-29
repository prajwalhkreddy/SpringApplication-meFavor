package utd.phk.web.controller;

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

	// ex: {context}/user/1
	@RequestMapping(value = "/user/id/{id}", method = RequestMethod.GET)
	
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
	@RequestMapping(value = "/user/byname", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@RequestParam("name") String name) {
		return null;
	}


	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public @ResponseBody int createUser(@RequestParam("fname") String fName, @RequestParam("lname") String lName, @RequestParam("address") String address, @RequestParam("zipcode") String zipcode, @RequestParam("gender") String gender) {
        String result = "success";    
        System.out.println("success");
        int status = userService.newUser(fName, lName, address, zipcode, gender);

        return status;
    }
}
