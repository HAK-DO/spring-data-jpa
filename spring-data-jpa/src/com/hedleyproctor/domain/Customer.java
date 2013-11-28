package com.hedleyproctor.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Customer {

	@Setter
	private Long id;
	@Setter
	@Getter
	private String forename;
	@Setter
	@Getter
	private String surname;
	@Setter
	private Set<Address> addresses = new HashSet<Address>();
	@Setter
	private List<PaymentCard> paymentCards = new ArrayList<PaymentCard>();

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<Address> getAddresses() {
		return addresses;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID", nullable = false)
	@OrderColumn(name = "CARD_INDEX")
	public List<PaymentCard> getPaymentCards() {
		return paymentCards;
	}

	public void addAddress(Address address) {
		getAddresses().add(address);
		address.setCustomer(this);
	}

	public void addPaymentCard(PaymentCard paymentCard) {
		getPaymentCards().add(paymentCard);
		paymentCard.setCustomer(this);
	}

	public void addPaymentCard(PaymentCard paymentCard, int index) {
		getPaymentCards().add(index, paymentCard);
		paymentCard.setCustomer(this);
	}
}
