package com.ecommerce.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.website.entity.Role;

@Repository
public interface RoleDao extends JpaRepository<Role, String>{

}