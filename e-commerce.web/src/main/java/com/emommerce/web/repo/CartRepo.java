package com.emommerce.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emommerce.web.models.Cart;

public interface CartRepo extends JpaRepository<Cart,Long>{
    
}
