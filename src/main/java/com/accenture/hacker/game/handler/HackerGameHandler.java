package com.accenture.hacker.game.handler;




import org.springframework.stereotype.Repository;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.service.HackerGameService;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

@Repository
public class HackerGameHandler extends HackerGameService  {

	public Credentials addingGroup(HackerGameRequest request) throws Exception  {
		Credentials credentials = new Credentials();
		credentials = getGroupByGroupName(request.getGroupName());
		if(credentials == null) {
			credentials = preparingRequestToSendIt(request);
			save(credentials);
			return credentials;
		}else {
			throw new Exception("The group name already exist");
		}
	}

	public Credentials getGroupByGroupName(String groupName) {
		return load(Credentials.class,groupName);
	}
	
	public HackerGameHandler(AmazonDynamoDB dynamoDB) {
		super(dynamoDB);
		// TODO Auto-generated constructor stub
	}
	
}
