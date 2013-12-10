package com.hedleyproctor.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
@SuppressWarnings("serial")
public class Authority implements GrantedAuthority {

    @Id
    private String authority;

    public Authority() {
    }

    public Authority(String authority) {
            this.authority = authority;
    }

    @Override
    public String getAuthority() {
            return authority;
    }

    public void setAuthority(String authority) {
            this.authority = authority;
    }
    
    private Account account;
    
    @ManyToOne
    public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}