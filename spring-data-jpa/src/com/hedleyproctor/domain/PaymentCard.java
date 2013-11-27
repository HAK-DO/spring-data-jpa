package com.hedleyproctor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class PaymentCard {
	private Long id;
	private String type;
	private String cardNumber;
	private String expiryDate;
	private String nameOnCard;
	private Customer customer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@ManyToOne
	@JoinColumn(name = "CUSTOMER_ID", nullable = false, insertable = false, updatable = false)
	public Customer getCustomer() {
		return customer;
	}
}
