package com.emommerce.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emommerce.web.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Long>{
    
}
