package com.emommerce.web.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emommerce.web.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
    @Query("select a from Customer a where a.user.username = ?1")
    Optional<Customer> findByUserName(String username);
}
