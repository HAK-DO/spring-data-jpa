package com.hedleyproctor.repository;

import org.springframework.data.repository.CrudRepository;

import com.hedleyproctor.domain.Account;

/**
 * @author hdlee <br/>
 * @category account<br/> singon<br/> profile<br/>
 */
public interface AccountRepository extends CrudRepository<Account, String>{
	Account findByEmail(String email);
}

