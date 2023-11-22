package com.emommerce.web.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emommerce.web.dto.ReqCustomerDto;
import com.emommerce.web.dto.ResCustomerDto;
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
		user.setRole("CUSTOMER");
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

    public ResponseEntity<Object> getCustomerById(Long id) {
        ResCustomerDto resCustomerDto = new ResCustomerDto();
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty() && optional.get().getCustomerStatus() == Status.ACTIVE) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("userid not found");
        }
        Customer customer = optional.get();
        resCustomerDto.setCustomerAddress(customer.getCustomerAddress());
        resCustomerDto.setCustomerName(customer.getCustomerName());
        resCustomerDto.setCustomerPhone(customer.getCustomerPhone());
        resCustomerDto.setCustomerStatus(customer.getCustomerStatus());
        resCustomerDto.setUsername(customer.getUser().getUsername());
        
        return  ResponseEntity.status(HttpStatus.OK).body(resCustomerDto);
    }

    public ResponseEntity<Object> getCustomerByUsername(String username) {
        ResCustomerDto resCustomerDto = new ResCustomerDto();
        Optional<Customer> optional = customerRepository.findByUserName(username);
        if (optional.isEmpty() && optional.get().getCustomerStatus() == Status.ACTIVE) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username not found");
        }
        Customer customer = optional.get();
        resCustomerDto.setCustomerAddress(customer.getCustomerAddress());
        resCustomerDto.setCustomerName(customer.getCustomerName());
        resCustomerDto.setCustomerPhone(customer.getCustomerPhone());
        resCustomerDto.setCustomerStatus(customer.getCustomerStatus());
        resCustomerDto.setUsername(customer.getUser().getUsername());
        
        return  ResponseEntity.status(HttpStatus.OK).body(resCustomerDto);
    }

    public ResponseEntity<Object> delCustomerByUsername(String username) {
        ResCustomerDto resCustomerDto = new ResCustomerDto();
        Optional<Customer> optional = customerRepository.findByUserName(username);
        if (optional.isEmpty() && optional.get().getCustomerStatus() == Status.ARCHIVED || optional.get().getCustomerStatus() == Status.REMOVED) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username not found");
        }
        resCustomerDto.setCustomerStatus(Status.ARCHIVED);
        return ResponseEntity.status(HttpStatus.OK).body("user removed sucessfully");
    }

    public ResponseEntity<Object> delCustomerById(Long id) {
        ResCustomerDto resCustomerDto = new ResCustomerDto();
        Optional<Customer> optional = customerRepository.findById(id);
        if (optional.isEmpty() && optional.get().getCustomerStatus() == Status.ARCHIVED || optional.get().getCustomerStatus() == Status.REMOVED) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username not found");
        }
        resCustomerDto.setCustomerStatus(Status.ARCHIVED);
        return ResponseEntity.status(HttpStatus.OK).body("user removed sucessfully");
    }

    public ResponseEntity<Object> updateCustomerDetailsByUsername(String username) {
        return null;
    }

    public ResponseEntity<Object> updateCustomerDetailsById(Long id) {
        return null;
    }

}
