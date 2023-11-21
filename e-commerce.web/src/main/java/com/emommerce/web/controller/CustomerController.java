package com.emommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emommerce.web.dto.ReqCustomerDto;
import com.emommerce.web.services.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
    
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Object> addCustomer(@RequestBody ReqCustomerDto rcd){
        return customerService.addCustomer(rcd);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id);
    }
     @GetMapping("/get/{username}")
    public ResponseEntity<Object> getCustomerByUsername(@PathVariable("username") String username){
        return customerService.getCustomerByUsername(username);
    }
}
