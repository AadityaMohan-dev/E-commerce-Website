package com.emommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emommerce.web.services.CartService;

@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Object> delCartElementById(@PathVariable("id") Long id){
        return cartService.delCartElementById(id);
    }
}
