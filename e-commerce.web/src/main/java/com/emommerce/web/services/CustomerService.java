package com.emommerce.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emommerce.web.dto.ReqCustomerDto;
import com.emommerce.web.enums.Status;
import com.emommerce.web.models.Customer;
import com.emommerce.web.models.User;
import com.emommerce.web.repo.CustomerRepo;
import com.emommerce.web.repo.UserRepo;

@Service
public class CustomerService {

    @Autowired
	private UserRepo userRepository;
    @Autowired
    private CustomerRepo customerRepository;
    public ResponseEntity<Object> addCustomer(ReqCustomerDto rcd) {
        User user = new User();
        user.setUsername(rcd.getUsername());
		user.setPassword(rcd.getPassword());
		user.setRole("ADMIN");
		// String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(user.getPassword());
		user = userRepository.save(user);

        Customer customer = new Customer();
        customer.setCustomerAddress(rcd.getCustomerAddress());
        customer.setCustomerName(rcd.getCustomerName());
        customer.setCustomerPhone(rcd.getCustomerPhone());
        customer.setCustomerStatus(Status.ACTIVE);
        customer.setUser(user);

        customerRepository.save(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Customer Added Sucessfully");
    }

}
