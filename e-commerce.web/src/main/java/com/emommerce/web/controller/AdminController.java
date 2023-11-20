package com.emommerce.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emommerce.web.dto.ReqAdminDto;
import com.emommerce.web.dto.ResAdminDto;
import com.emommerce.web.services.AdminService;
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

    @GetMapping("get/{username}")
    public ResponseEntity<Object> getAdminByUserName(@RequestBody ResAdminDto resAdminDto,@PathVariable("username") String username) {
        return adminService.getAdminByUserName(resAdminDto, username);
    }
    
}
