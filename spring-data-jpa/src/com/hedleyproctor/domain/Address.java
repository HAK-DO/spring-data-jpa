package com.hedleyproctor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;


@Entity
public class Address {
	@Setter
    private Long id;

	@Setter
    private Customer customer;
	@Setter
	@Getter
    private String line1;
	@Setter
	@Getter
    private String line2;
	@Setter
	@Getter
    private String line3;
	@Setter
	@Getter
    private String line4;
	@Setter
	@Getter
    private String town;
	@Setter
	@Getter
    private String county;
	@Setter
	@Getter
    private String postcode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    @ManyToOne
    public Customer getCustomer() {
        return customer;
    }
}

