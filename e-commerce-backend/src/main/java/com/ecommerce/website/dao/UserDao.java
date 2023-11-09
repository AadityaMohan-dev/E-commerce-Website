package com.ecommerce.website.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.website.entity.User;

public interface UserDao extends JpaRepository<User, String>{

}
