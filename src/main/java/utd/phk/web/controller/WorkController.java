package utd.phk.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class WorkController {
	
	//Work Submit Page
		@RequestMapping(value = "/work/create", method = RequestMethod.POST)
	    @ResponseStatus(value=HttpStatus.OK)
	    public @ResponseBody boolean createUser(@RequestParam("workdescription") String workDesc, @RequestParam("completeby") String completeby, @RequestParam("startloc") String startloc, @RequestParam("endloc") String endloc, @RequestParam("cost") String cost) {
	        String result = "success";    
	        System.out.println("success");
	        boolean status = userService.newUser(fName, lName, address, zipcode, gender, phnumber, username, password);

	        return status;
	    }

}
