package com.accenture.hacker.game.entity;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



@EnableScan
public interface CredentialsRepository extends CrudRepository<Credentials, String> {
	
	@Query(value="Select * from credentials where groupName= :groupName")
	public List<Credentials> sqlInjection(@Param(value="groupName")String groupName);

}
