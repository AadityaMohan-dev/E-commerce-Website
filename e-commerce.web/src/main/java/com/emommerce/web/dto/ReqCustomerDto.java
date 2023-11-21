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
public class ReqCustomerDto {
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private Status customerStatus;
    private String username;
    private String password;
}
