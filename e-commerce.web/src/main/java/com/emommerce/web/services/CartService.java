package com.emommerce.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.emommerce.web.repo.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepository;
    public ResponseEntity<Object> delCartElementById(Long id) {
        return null;
    }
    
}
