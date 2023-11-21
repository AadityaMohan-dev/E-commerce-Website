package com.emommerce.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emommerce.web.dto.ReqCustomerDto;
import com.emommerce.web.repo.CustomerRepo;
import com.emommerce.web.repo.UserRepo;

@Service
public class CustomerService {

    @Autowired
	private UserRepo userRepository;
    @Autowired
    private CustomerRepo customerRepository;
    public ResponseEntity<Object> addCustomer(ReqCustomerDto rcd) {
        return null;
    }

}
