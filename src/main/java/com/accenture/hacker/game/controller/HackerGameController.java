package com.accenture.hacker.game.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.handler.HackerGameHandler;

@RestController
@RequestMapping("cxf/hacker-game/login")
public class HackerGameController {

	
	@Autowired 
	HackerGameHandler hackerGameHandler;
	
	
	@PostMapping
	public ResponseEntity<Credentials> saveGroup(@Valid @RequestBody HackerGameRequest request) {
		return ResponseEntity.ok(hackerGameHandler.addingGroup(request));
		
	}
	
	@GetMapping("/{id}")
	public Credentials getGroup(@PathVariable(value = "id")String id) {
		return hackerGameHandler.getGroupById(id);
	}
	
	
	
}
