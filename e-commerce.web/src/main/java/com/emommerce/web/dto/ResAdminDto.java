package com.emommerce.web.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResAdminDto {
    private String AdminName;
    private String AdminAddress;
    private String AdminPhone;
    private String username;
}
