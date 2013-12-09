package com.hedleyproctor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hedleyproctor.domain.Account;
import com.hedleyproctor.repository.AccountRepository;

import config.ApplicationConfig;

/**
 * @author hdlee
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class AccountTest {

	@Autowired AccountRepository accountRepository;

//	@Test
	public void saveOrUpdateAccount() {
		Account account = accountRepository.findOne("TEST2");
		if (account == null) {
			account = new Account();
			account.setEmail("TEST2");
		}
//		BannerData bannerData = new BannerData();
//		bannerData.setFavouriteCategoryId("TEST");
//		account.setBannerData(bannerData);
		account.setPassword("qwer12345");
		accountRepository.save(account);
	}
	
	@Test
	public void findOne(){
		Account account = accountRepository.findOne("TEST2");
		System.out.println(account);
		
	}
}
