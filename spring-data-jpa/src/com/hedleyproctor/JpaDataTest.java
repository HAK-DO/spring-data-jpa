package com.hedleyproctor;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hedleyproctor.config.AppConfig;
import com.hedleyproctor.domain.Address;
import com.hedleyproctor.domain.Customer;
import com.hedleyproctor.domain.PaymentCard;
import com.hedleyproctor.repository.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class JpaDataTest {

	@Autowired CustomerRepository customerRepository;
	
	@PersistenceContext
    private EntityManager em;

//	@Test 
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
	@Test public void insertCustomerCard(){
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

        Iterable<Customer> customers = customerRepository.findAll();
        for (Customer cus : customers) {
            Set<Address> addresses = cus.getAddresses();
        }
//        Customer retrievedCustomer = (Customer) customerRepository.findOne(1L);
//        List<PaymentCard> paymentCards = retrievedCustomer.getPaymentCards();
//        for (PaymentCard paymentCard : paymentCards) {
//			System.out.println(paymentCard);
//		}
	}
}
