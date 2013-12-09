package com.hedleyproctor;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hedleyproctor.domain.Address;
import com.hedleyproctor.domain.Customer;
import com.hedleyproctor.domain.PaymentCard;

import config.ApplicationConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ApplicationConfig.class)
public class JpaSampleDataTest {

	@Autowired CustomerRepository customerRepository;
	

//	@Test 
//	@Transactional(propagation=Propagation.REQUIRED)
	public void insertCustomerAddress(){
		Customer customer = new Customer();
        customer.setForename("Joe");
        customer.setSurname("Bloggs");

        Address homeAddress = new Address();
        homeAddress.setLine1("10 Park Avenue");
        homeAddress.setTown("London");
        homeAddress.setPostcode("SW12RT");
        customer.addAddress(homeAddress);

        Address workAddress = new Address();
        workAddress.setLine1("15 Maple Road");
        workAddress.setTown("Sheffield");
        workAddress.setPostcode("SH142YU");
        customer.addAddress(workAddress);
		customerRepository.save(customer);
	}
//	@Test
	public void insertCustomerCard(){
        Customer customer = new Customer();
        customer.setForename("Joe");
        customer.setSurname("Bloggs");

        PaymentCard visa = new PaymentCard();
        visa.setType("VISA");
        visa.setCardNumber("1234567812345678");
        visa.setNameOnCard("Mr J Bloggs");
        visa.setExpiryDate("0614");
        
        PaymentCard masterCard = new PaymentCard();
        masterCard.setType("MASTERCARD");
        masterCard.setCardNumber("8765432187654321");
        masterCard.setNameOnCard("Mr Joe Bloggs");
        masterCard.setExpiryDate("0714");
        
        PaymentCard amex = new PaymentCard();
        amex.setType("AMEX");
        amex.setCardNumber("1122334455667788");
        amex.setNameOnCard("Joe Bloggs");
        amex.setExpiryDate("0814");
        
        customer.addPaymentCard(visa);
        customer.addPaymentCard(masterCard);
        customer.addPaymentCard(amex,1);
        customerRepository.save(customer);

	}
	
	@Test
	@Transactional
	public void select(){
        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer cus : customers) {
        	List<PaymentCard> cards = cus.getPaymentCards();
        	for (PaymentCard paymentCard : cards) {
				System.out.println(paymentCard);
			}
        }
	}
}
