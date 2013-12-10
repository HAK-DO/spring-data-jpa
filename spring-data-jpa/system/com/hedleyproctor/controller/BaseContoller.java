package com.hedleyproctor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hedleyproctor.repository.AccountRepository;

@Controller
public class BaseContoller {
	
	@Autowired AccountRepository repository;
	
	@RequestMapping("/")
	public String index(){
		System.out.println(repository.findOne("TEST2"));
		return "basic/Home";
	}
}
