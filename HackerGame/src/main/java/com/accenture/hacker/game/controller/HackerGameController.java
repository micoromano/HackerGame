package com.accenture.hacker.game.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.service.HackerGameHandler;

@RestController
public class HackerGameController {

	
	@Autowired 
	HackerGameHandler hackerGameHandler;
	
	
	@PostMapping(path = "/cxf/hacker-game/registration")
	public ResponseEntity<Credentials> saveGroup(@RequestBody Credentials request) {
		return ResponseEntity.ok(hackerGameHandler.addingGroup(request));
		
	}
	
	@GetMapping(path = "cxf/hacker-game/registration/{id}")
	public ResponseEntity<Optional<Credentials>> getGroup(@PathVariable String id) {
		System.out.println(id);
		return ResponseEntity.ok(hackerGameHandler.getGroup(id));
	}
	
	@GetMapping(path = "cxf/hacker-game/registration/{request}")
	public ResponseEntity<List<Credentials>> sqlInjection(@PathVariable String request) {
		System.out.println(request);
		return ResponseEntity.ok(hackerGameHandler.sqlInjection(request));
	}
	
	
	
	
}
