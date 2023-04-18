package com.accenture.hacker.game.bean;

import javax.validation.constraints.NotNull;

public class HackerGameRequest {

	@NotNull(message="The groupName can not be null")
	private String groupName;
	
	@NotNull(message="The password can not be null")
	private String password;
	
	
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
