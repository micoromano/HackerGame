package com.accenture.hacker.game.handler;




import org.springframework.stereotype.Repository;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.service.HackerGameService;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

@Repository
public class HackerGameHandler extends HackerGameService  {



	public Credentials addingGroup(HackerGameRequest request)  {
		
		Credentials credentials = preparingRequestToSendIt(request);
		save(credentials);
		return credentials;
		
	}

	public Credentials getGroupById(String id) {
		return load(Credentials.class,id);
	}
	

	public HackerGameHandler(AmazonDynamoDB dynamoDB) {
		super(dynamoDB);
	}
	
}
