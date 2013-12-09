package com.hedleyproctor.service;

import javax.annotation.PostConstruct;

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

	@PostConstruct
	public void load() {
		Account account = accountRepository.findOne("TEST2");
		if (account == null) {
			account = new Account();
			account.setEmail("TEST2");
		}
		Authority authority = new Authority("ROLE_USER");
		authorityRepository.save(authority);
		account.setPassword("secret");
		account.getAuthorities().add(authority);
		accountRepository.save(account);
	}
}