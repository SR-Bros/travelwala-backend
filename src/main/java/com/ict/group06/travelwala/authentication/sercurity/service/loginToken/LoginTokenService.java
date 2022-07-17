package com.ict.group06.travelwala.authentication.sercurity.service.loginToken;

import com.ict.group06.travelwala.authentication.sercurity.entity.AppUser;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface LoginTokenService {
    LoginToken refreshToken(HttpServletRequest request) throws IOException;

    LoginToken createToken(AppUser user);
}
