package com.accenture.hacker.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.service.HackerGameService;

@RestController
@RequestMapping("/cxf/group")
public class HackerGameController {

	
	@Autowired HackerGameService hackerGameService;
	
	
	@PostMapping(path = "/registration")
	public String saveGroup(HackerGameRequest request) {
		
		String id = hackerGameService.addingGroup(request);
		
		return id;
		
	}
	
	
	
	
	
}
