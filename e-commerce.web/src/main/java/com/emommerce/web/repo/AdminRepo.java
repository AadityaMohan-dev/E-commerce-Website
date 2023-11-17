package com.emommerce.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emommerce.web.models.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long>{
    
}
