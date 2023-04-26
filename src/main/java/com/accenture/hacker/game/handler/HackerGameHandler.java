package com.accenture.hacker.game.handler;


import org.springframework.stereotype.Repository;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.entity.FirstLevel;
import com.accenture.hacker.game.service.HackerGameService;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

@Repository
public class HackerGameHandler extends HackerGameService  {

	public Credentials addingGroup(HackerGameRequest request) throws Exception  {
		Credentials credentials = new Credentials();
		credentials = getGroupByFilters(request);
		if(credentials == null) {
			save(preparingRequestToSendIt(request));
			return credentials;
		}else {
			throw new Exception("The group name already exist");
		}
	}

	public Credentials getGroupByFilters(HackerGameRequest request) {		Credentials loading = new Credentials();
		loading.setGroupName(request.getGroupName());
		loading.setPassword(request.getPassword());
		return load(loading);
	}
	
	public FirstLevel getPass(HackerGameRequest request) throws Exception {
		FirstLevel loading = new FirstLevel();
		loading.setPassword(request.getPassword());
		if(load(loading)!= null) {
		return load(loading);
		}else {
			throw new Exception("The password doesn't exist");
		}
	}
	
	public Credentials login(HackerGameRequest request) throws Exception {
		Credentials gruppoLoggato= load(Credentials.class,request.getGroupName());
		if(gruppoLoggato!=null && gruppoLoggato.getPassword().equals(request.getPassword())) {
			return gruppoLoggato;
		}
		else {
			throw new Exception("Username o password errati");
		}		 
	}

	
	public HackerGameHandler(AmazonDynamoDB dynamoDB) {
		super(dynamoDB);
	}

	
}
