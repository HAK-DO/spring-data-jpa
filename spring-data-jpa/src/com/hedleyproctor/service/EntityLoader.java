package com.hedleyproctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hedleyproctor.domain.Account;
import com.hedleyproctor.domain.Authority;
import com.hedleyproctor.repository.AccountRepository;
import com.hedleyproctor.repository.AuthorityRepository;

@Component
public class EntityLoader {

	@Autowired AccountRepository accountRepository;
	@Autowired AuthorityRepository authorityRepository;

	public void load() {
		Account account = accountRepository.findOne("TEST2");
		if (account == null) {
			account = new Account();
			account.setEmail("TEST2"); 
			account.setPassword("secret");
		}
		Authority authority = authorityRepository.findOne("ROLE_USER");
		if (authority == null) {
			authority = new Authority("ROLE_USER");
			account.getAuthorities().add(authority);
		}
		accountRepository.save(account);
	}
}