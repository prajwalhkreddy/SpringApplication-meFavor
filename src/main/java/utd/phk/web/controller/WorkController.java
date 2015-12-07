package utd.phk.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import utd.phk.web.model.OpenWorks;
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
	public @ResponseBody int createWork(@RequestParam("workdescription") String workDesc,
			@RequestParam("createdBy") String createdby, 
			@RequestParam("completeBy") String completeby,
			@RequestParam("startLoc") String startloc, 
			@RequestParam("endLoc") String endloc,
			@RequestParam("cost") String cost) {
		String result = "success";
		System.out.println("success");
		int status = workService.createWork(workDesc, createdby, completeby, startloc, endloc, cost);

		return status;
	}

	// Retrieve OpenWork Details
	@RequestMapping(value = "/work/get", method = RequestMethod.GET) 
	public @ResponseBody List<OpenWorks> getWorks(@RequestParam("compstatus") String compstatus, HttpServletResponse response) {
		List<OpenWorks> workdetails = new ArrayList<OpenWorks>();
		workdetails  = workService.getWork(compstatus);
		if (workdetails == null) {
			response.setStatus(404);
			return workdetails;
		}
		//workdetails = new ResponseEntity<User>(user, HttpStatus.OK);
		return workdetails;
	}

	
	//Update Works table when a user accepts to complete work
	@RequestMapping(value = "/work/update", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody int updateWork(@RequestParam("workid") String workID,
			@RequestParam("acceptorid") String acceptorID,
			@RequestParam("compstatus") String compstatus){
		int status = workService.updateWork(workID,acceptorID,compstatus);

		return status;
	}
	
	
	
}
