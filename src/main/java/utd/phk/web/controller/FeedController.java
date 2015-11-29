package utd.phk.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import utd.phk.web.model.Feed;
import utd.phk.web.service.FeedService;

@Controller
@RequestMapping(value = "/feed")
public class FeedController {
	
	@Autowired
	private FeedService feedService;

	
	@RequestMapping(value="/{user}")
	public ResponseEntity<Feed> getFeed(@PathVariable("user") String user) {
		Feed feed = feedService.getFeed(user);
		return new ResponseEntity<Feed>(feed, HttpStatus.OK);
	}
}
