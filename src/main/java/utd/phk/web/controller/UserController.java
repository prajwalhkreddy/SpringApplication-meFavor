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
	@RequestMapping(value = "/user/id/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") String emailId, HttpServletResponse response) {
		ResponseEntity<User> dummy = null;
		User user = userService.getUser(emailId);
		if (user == null) {
			response.setStatus(404);
			return dummy;
		}
		dummy = new ResponseEntity<User>(user, HttpStatus.OK);
		return dummy;
	}

	/// user?name="Prajwal"
	@RequestMapping(value = "/user/byname", method = RequestMethod.GET)
	public ResponseEntity<User> getUserByName(@RequestParam("name") String name) {
		return null;
	}

	/*@RequestMapping(value = "/user/new", method = RequestMethod.POST)
	@ResponseStatus(value=HttpStatus.OK)
	public String createUser(@RequestBody User newUser) {
		String result = "success";	
		if (newUser != null) {
			System.out.println(newUser.getfName());
		} else {
			System.out.println("user null");
		}
		if (userService.newUser(newUser) < 0) {
			result = "failure";
		}

		return result;
	}*/
	
	@RequestMapping(value = "/user/new", method = RequestMethod.POST)
    @ResponseStatus(value=HttpStatus.OK)
    public @ResponseBody int createUser(@RequestParam("name") String fName) {
        String result = "success";    
        System.out.println("success");
        int status = userService.newUser(fName);

        return status;
    }
}
