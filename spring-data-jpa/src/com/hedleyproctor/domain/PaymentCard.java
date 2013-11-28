package com.hedleyproctor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
public class PaymentCard {
	@Setter
	private Long id;
	@Setter
	@Getter
	private String type;
	@Setter
	@Getter
	private String cardNumber;
	@Setter
	@Getter
	private String expiryDate;
	@Setter
	@Getter
	private String nameOnCard;
	@Setter
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
