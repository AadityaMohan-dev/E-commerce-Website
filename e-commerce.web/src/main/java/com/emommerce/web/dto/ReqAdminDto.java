package com.emommerce.web.dto;

import org.springframework.stereotype.Component;

import com.emommerce.web.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReqAdminDto {
    private String AdminName;
    private String AdminAddress;
    private String AdminPhone;
    private String username;
    private String password;
    private Status activeStatus;
}
