package com.emommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emommerce.web.dto.ReqAdminDto;
import com.emommerce.web.services.AdminService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/admin")
public class AdminController {


    @Autowired
	private AdminService adminService;
	
	@PostMapping("add")
	public ResponseEntity<Object> addAdmin(@RequestBody ReqAdminDto rad){
		return adminService.addAdmin(rad);
	}

    @GetMapping("user/{username}")
    public ResponseEntity<Object> getAdminByUserName(@PathVariable("username") String username) {
        return adminService.getAdminByUserName(username);
    }

    @GetMapping("userid/{id}")
    public ResponseEntity<Object> getAdminById(@PathVariable("id") Long id){
        return adminService.getAdminById(id);
    }

    @DeleteMapping("user/del/{id}")
    public ResponseEntity<Object> delAdminById(@PathVariable("id") Long id){
        return adminService.delAdminById(id);
    }
}
