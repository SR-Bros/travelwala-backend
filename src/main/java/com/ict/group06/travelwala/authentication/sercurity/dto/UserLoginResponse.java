package com.ict.group06.travelwala.authentication.sercurity.dto;

import com.ict.group06.travelwala.authentication.sercurity.entity.Provider;
import lombok.Data;

@Data
public class UserLoginResponse {
    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String telephone;
    private Provider provider;
}
