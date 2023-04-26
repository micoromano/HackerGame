package com.accenture.hacker.game.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@DynamoDBTable(tableName="firstLevel")
public class FirstLevel {
	
	
	@DynamoDBAttribute(attributeName = "password")
	@DynamoDBHashKey
	@Getter @Setter
	private String password;

}
