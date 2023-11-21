package com.emommerce.web.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emommerce.web.dto.ReqAdminDto;
import com.emommerce.web.dto.ResAdminDto;
import com.emommerce.web.models.Admin;
import com.emommerce.web.models.User;
import com.emommerce.web.repo.AdminRepo;
import com.emommerce.web.repo.UserRepo;

@Service
public class AdminService {
    @Autowired
	private UserRepo userRepository;
	// @Autowired
	// private PasswordEncoder passwordEncoder;
	@Autowired
	private AdminRepo adminRepository;
	
	public ResponseEntity<Object> addAdmin(ReqAdminDto rad) {
		
		User user = new User();
		user.setUsername(rad.getUsername());
		user.setPassword(rad.getPassword());
		user.setRole("ADMIN");
		// String encodePassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(user.getPassword());
		user = userRepository.save(user);
		
		Admin admin = new Admin();
		admin.setAdminName(rad.getAdminName());
        admin.setAdminAddress(rad.getAdminAddress());
        admin.setAdminPhone(rad.getAdminPhone());
		admin.setUser(user);
		
		adminRepository.save(admin);
		
		return ResponseEntity.status(HttpStatus.OK).body("Admin Added Sucessfully");
	}

   
    public ResponseEntity<Object> getAdminByUserName(String username) {
        ResAdminDto resAdminDto =new ResAdminDto();
        Optional<Admin> optional = adminRepository.findByUserName(username);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("username not found");
        }
        Admin admin = optional.get();
        resAdminDto.setAdminAddress(admin.getAdminAddress());
        resAdminDto.setAdminName(admin.getAdminName());
        resAdminDto.setAdminPhone(admin.getAdminPhone());
        resAdminDto.setUsername(admin.getUser().getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(resAdminDto);
    }


    public ResponseEntity<Object> getAdminById(Long id) {
        ResAdminDto resAdminDto =new ResAdminDto();
        Optional<Admin> optional = adminRepository.findById(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("userid not found");
        }
        Admin admin = optional.get();
        resAdminDto.setAdminAddress(admin.getAdminAddress());
        resAdminDto.setAdminName(admin.getAdminName());
        resAdminDto.setAdminPhone(admin.getAdminPhone());
        resAdminDto.setUsername(admin.getUser().getUsername());

        return ResponseEntity.status(HttpStatus.OK).body(resAdminDto);
    }
}
