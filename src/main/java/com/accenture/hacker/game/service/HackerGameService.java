package com.accenture.hacker.game.service;

import org.springframework.stereotype.Service;

import com.accenture.hacker.game.bean.HackerGameRequest;
import com.accenture.hacker.game.entity.Credentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Service
public class HackerGameService extends DynamoDBMapper  {


	public Credentials preparingRequestToSendIt(HackerGameRequest request) {
		Credentials crendialts = new Credentials();
		crendialts.setGroupName(request.getGroupName());
		crendialts.setPassword(request.getPassword());
		return crendialts;
	}
	
	public HackerGameService(AmazonDynamoDB dynamoDB) {
		super(dynamoDB);
	}
	
	
}
