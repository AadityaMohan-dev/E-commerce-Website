package com.emommerce.web.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.emommerce.web.models.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long>{
    @Query("select a from Admin a where a.user.username = ?1")
    Optional<Admin> findByUserName(String username);
    
}
