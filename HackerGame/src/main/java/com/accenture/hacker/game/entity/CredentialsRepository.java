package com.accenture.hacker.game.entity;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface CredentialsRepository extends CrudRepository<Credentials, String> {

}
