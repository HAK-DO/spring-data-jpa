package com.hedleyproctor.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hedleyproctor.domain.Account;
import com.hedleyproctor.domain.Authority;
import com.hedleyproctor.repository.AccountRepository;
import com.hedleyproctor.repository.AuthorityRepository;

/**
 * @author hdlee
 */
@Service
public class AccountService implements UserDetailsService {

	@Autowired AccountRepository accountRepository;
	@Autowired AuthorityRepository authorityRepository;

	@PostConstruct
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
	
	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(username);
		if (account == null)
			throw new UsernameNotFoundException(username);
		return account;
	}

	public Account create(Account account) {
		return accountRepository.save(account);
	}

	@Transactional
	public Account read(String email) {
		return accountRepository.findOne(email);
	}

	public void update(Account account) {
		accountRepository.save(account);
	}

	public void delete(String email) {
		accountRepository.delete(email);
	}

	public Object list() {
		return accountRepository.findAll();
	}
}