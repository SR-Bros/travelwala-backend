package com.ict.group06.travelwala.authentication.sercurity.dto;

import com.ict.group06.travelwala.authentication.sercurity.service.loginToken.LoginToken;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
    LoginToken loginToken;
    UserLoginResponse user;
}
