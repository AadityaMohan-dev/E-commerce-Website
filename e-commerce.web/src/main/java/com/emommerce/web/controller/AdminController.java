package com.emommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emommerce.web.dto.ReqAdminDto;
import com.emommerce.web.services.AdminService;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
	private AdminService adminService;
	
	@PostMapping("add")
	public ResponseEntity<Object> addAdmin(@RequestBody ReqAdminDto rad){
		return adminService.addAdmin(rad);
	}
}
