package com.emommerce.web.dto;

import org.springframework.stereotype.Controller;

import com.emommerce.web.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Controller
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResCustomerDto {
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private Status customerStatus;
    private String username;
}
