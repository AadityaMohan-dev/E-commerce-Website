package com.ecommerce.website.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.website.dao.UserDao;
import com.ecommerce.website.entity.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public User registerNewUser(User user) {
		return userDao.save(user);
	}
}
