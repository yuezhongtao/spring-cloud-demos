package com.example.oauth2authorizationserver.auth;

import com.example.oauth2authorizationserver.dto.LoginBody;
import com.example.oauth2authorizationserver.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private AuthenticationManager am;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    LoginResponse login(@RequestBody LoginBody loginBody){
        try {
            Authentication request = new UsernamePasswordAuthenticationToken(loginBody.getUsername(),loginBody.getPassword());
            Authentication result = am.authenticate(request);
            SecurityContextHolder.getContext().setAuthentication(result);
            return new LoginResponse("success");
        } catch(AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
        return new LoginResponse("fail");
    }


}
