package com.accenture.hacker.game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.entity.FirstLevel;
import com.accenture.hacker.game.handler.HackerGameHandler;

@RestController
@RequestMapping("cxf/hacker-game/home")
public class HackerGameController {

	
	@Autowired 
	HackerGameHandler hackerGameHandler;
	
	
	@PostMapping("/saveGroup")
	public ResponseEntity<Credentials> saveGroup(@Valid @RequestBody HackerGameRequest request) throws Exception {
		return ResponseEntity.ok(hackerGameHandler.addingGroup(request));
		
	}
	
	@GetMapping("/login")
	public Credentials retrieveGroup(@RequestParam(value = "groupName")String groupName,
									 @RequestParam(value = "password")String password) {
		HackerGameRequest request = new HackerGameRequest();
		request.setGroupName(groupName);
		request.setPassword(password);
		return hackerGameHandler.getGroupByFilters(request);
	}
	
	@GetMapping("/first-level/pass")
	public FirstLevel retrieveFirstLevelPass(@RequestParam(value = "password")String password) throws Exception {
		HackerGameRequest request = new HackerGameRequest();
		request.setPassword(password);
		return hackerGameHandler.getPass(request);
	}	
}
