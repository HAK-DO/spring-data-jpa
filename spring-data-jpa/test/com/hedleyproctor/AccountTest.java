package com.hedleyproctor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hedleyproctor.service.AccountService;
import com.hedleyproctor.service.EntityLoader;

import config.ApplicationConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AccountTest {

	@Autowired
	EntityLoader entityLoader;

	@Autowired
	AccountService accountService;

	// @Test
	public void saveOrUpdateAccount() {
		entityLoader.load();
	}

	@Test
	public void findOne() {
		UserDetails userDetails = accountService.loadUserByUsername("TEST2");
		System.out.println(userDetails);
	}
}
