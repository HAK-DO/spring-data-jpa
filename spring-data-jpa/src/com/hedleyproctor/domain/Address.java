package com.hedleyproctor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;


@Entity
@Data
public class Address {
    private Long id;

    private Customer customer;
    private String line1;
    private String line2;
    private String line3;
    private String line4;
    private String town;
    private String county;
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

