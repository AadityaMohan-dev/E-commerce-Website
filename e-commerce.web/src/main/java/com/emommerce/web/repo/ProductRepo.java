package com.emommerce.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emommerce.web.models.Product;

public interface ProductRepo extends JpaRepository<Product,Long>{
    
}
