package utd.phk.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import utd.phk.web.model.User;
import utd.phk.web.model.Work;
import utd.phk.web.service.WorkService;

@Controller
public class WorkController {

	@Autowired
	private WorkService workService;

	// Work Submit Page
	@RequestMapping(value = "/work/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody int createUser(@RequestParam("workdescription") String workDesc,
			@RequestParam("createdBy") String createdby, @RequestParam("completeBy") String completeby,
			@RequestParam("startLoc") String startloc, @RequestParam("endLoc") String endloc,
			@RequestParam("cost") String cost) {
		String result = "success";
		System.out.println("success");
		int status = workService.createWork(workDesc, createdby, completeby, startloc, endloc, cost);

		return status;
	}

	// Retrieve User Details
	@RequestMapping(value = "/work/open", method = RequestMethod.GET) 
	// @ResponseBody List<User>
	public @ResponseBody List<Work> getWorks(HttpServletResponse response) {
		List<Work> workdetails = new ArrayList<Work>();
		workdetails  = workService.getWork();
		if (workdetails == null) {
			response.setStatus(404);
			return workdetails;
		}
		//workdetails = new ResponseEntity<User>(user, HttpStatus.OK);
		return workdetails;
	}

}
