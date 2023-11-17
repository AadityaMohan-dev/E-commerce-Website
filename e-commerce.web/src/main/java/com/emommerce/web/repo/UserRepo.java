package com.emommerce.web.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emommerce.web.models.User;

public interface UserRepo extends JpaRepository<User,Long>{
    
}
