package com.example.oauth2authorizationserver.controller;

import com.example.oauth2authorizationserver.dto.RespDTO;
import com.example.oauth2authorizationserver.entity.Test;
import com.example.oauth2authorizationserver.entity.TestEnum;
import com.example.oauth2authorizationserver.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/test")
public class TestController {


    @Autowired
    private TestRepository testRepository;

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    RespDTO save(){
        Test test = new Test();
        test.setEnumTest(TestEnum.hehe2);
        testRepository.save(test);
        Test test2 = testRepository.findOne(1L);
        System.out.println(test2.getEnumTest());
        return new RespDTO("success");
    }

}
