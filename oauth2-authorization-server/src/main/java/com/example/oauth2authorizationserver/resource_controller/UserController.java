package com.example.oauth2authorizationserver.resource_controller;

import com.example.oauth2authorizationserver.entity.MyUserDetail;
import com.example.oauth2authorizationserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody List<MyUserDetail> list(){
        return userRepository.findAll();
    }

}
