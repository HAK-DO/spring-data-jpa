package com.hedleyproctor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hedleyproctor.domain.Account;
import com.hedleyproctor.repository.AccountRepository;

/**
 * @author hdlee
 */
@Service
public class AccountService implements UserDetailsService {

	@Autowired AccountRepository accountRepository;

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByEmail(username);
		if (account == null)
			throw new UsernameNotFoundException(username);
		return account;
	}
}