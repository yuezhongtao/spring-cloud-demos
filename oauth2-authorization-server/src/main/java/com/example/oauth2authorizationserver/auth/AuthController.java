package com.example.oauth2authorizationserver.auth;

import com.example.oauth2authorizationserver.dto.LoginBody;
import com.example.oauth2authorizationserver.dto.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private AuthenticationManager am;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public @ResponseBody
    LoginResponse login(@RequestBody LoginBody loginBody, HttpServletRequest request, HttpServletResponse response){
//        Authentication arequest = tokenServices.autoLogin(request,response);
//        Authentication result = am.authenticate(arequest);
//        SecurityContextHolder.getContext().setAuthentication(result);
//        return new LoginResponse("success",arequest.getCredentials().toString());


        try {
            Authentication arequest = new UsernamePasswordAuthenticationToken(loginBody.getUsername(),loginBody.getPassword());
            Authentication result = am.authenticate(arequest);
            SecurityContextHolder.getContext().setAuthentication(result);
            return new LoginResponse("success",arequest.getCredentials().toString());
        } catch(AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }
        return new LoginResponse("fail");
    }


}
