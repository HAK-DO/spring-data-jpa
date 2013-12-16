package com.hedleyproctor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.hedleyproctor.domain.Account;
public class AccountControllerTest {
    private static final String REST_SERVICE_URL = "http://localhost:8080/spring-data-jpa/account";
    private RestTemplate restTemplate;
 
    @Before
    public void beforeClass() {
        restTemplate = new RestTemplate();
    }
 
 
    @Test
    public void read() {
    	List<HttpMessageConverter<?>> list = new ArrayList<HttpMessageConverter<?>>();
    	list.add(new MappingJacksonHttpMessageConverter());
    	restTemplate.setMessageConverters(list);
        Account account = restTemplate.getForObject(REST_SERVICE_URL + "/{email}", Account.class, "TEST2");
    }
 
}