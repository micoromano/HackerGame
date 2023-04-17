package com.accenture.hacker.game.service;


import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.accenture.hacker.game.entity.Credentials;
import com.accenture.hacker.game.entity.CredentialsRepository;

@Service
@Repository
public class HackerGameHandler  {

	@Autowired
	private CredentialsRepository credentialsRepository;
	
	public Credentials addingGroup(Credentials Credenziali)  {
		credentialsRepository.save(Credenziali);
		return Credenziali;
	}

	public Optional<Credentials> getGroup(String id) {

		if(!StringUtils.isEmpty(id)) {
			System.out.println("---------->"+id);
			return credentialsRepository.findById(id);
		}else {
			return null;
		}
	}
	
	public List<Credentials> sqlInjection(String request) {

		if(!StringUtils.isEmpty(request)) {
			System.out.println("---------->"+request);
			return credentialsRepository.sqlInjection(request);
		}else {
			return null;
		}
	}

}
