package com.hedleyproctor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hedleyproctor.domain.Account;
import com.hedleyproctor.service.AccountService;

@Controller
@RequestMapping(value = "/account")
public class AccountContoller {
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountContoller.class);
  
    @Autowired   
    private AccountService accountService;
 
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Account create(@RequestBody Account account) {
        LOGGER.info("Creating new user {}", account);
        return accountService.create(account);
    }
 
    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    @ResponseBody
    public UserDetails read(@PathVariable(value = "email") String email) {
        LOGGER.info("Reading user with id {}", email);
        UserDetails user = accountService.loadUserByUsername(email);
//        Validate.isTrue(user != null, "Unable to find user with id: " + userId);
        return user;
    }
 
    @RequestMapping(value = "/{email}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(@PathVariable(value = "email") String email, @RequestBody Account account) {
        LOGGER.info("Updating user with id {} with {}", email, account);
//        Validate.isTrue(userId == account.getId(), "userId doesn't match URL userId: " + account.getId());
        accountService.update(account);
    }
 
    @RequestMapping(value = "/{email}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable(value = "email") String email) {
        LOGGER.info("Deleting user with id {}", email);
        accountService.delete(email);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        LOGGER.info("Listing users");
        return accountService.list();
    }
 
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleClientErrors(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
 
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String handleServerErrors(Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return ex.getMessage();
    }
}