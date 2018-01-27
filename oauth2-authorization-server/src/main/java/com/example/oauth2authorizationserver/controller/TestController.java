package com.example.oauth2authorizationserver.controller;

import com.example.oauth2authorizationserver.dto.JsonTest;
import com.example.oauth2authorizationserver.dto.RespDTO;
import com.example.oauth2authorizationserver.entity.Test;
import com.example.oauth2authorizationserver.entity.TestEnum;
import com.example.oauth2authorizationserver.entity.TestEnum2;
import com.example.oauth2authorizationserver.repository.TestRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

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
        test.setEnum2(TestEnum2.TT2);
        testRepository.save(test);
        Test test2 = testRepository.findOne(1L);
        System.out.println(test2.getEnumTest());
        return new RespDTO("success",test2);
    }
    @RequestMapping(value = "/json", method = RequestMethod.POST)
    @ResponseBody RespDTO jsonTest(@RequestBody JsonTest jsonTest){
        System.out.println(jsonTest.toString());
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = "{" +
                "\"a\":\"test-aa\"," +
                "\"b\":\"test-bb\"" +
                "}";
        try {
            JsonTest jsonTest1 = mapper.readValue(jsonStr,JsonTest.class);
            return new RespDTO("success",jsonTest1);
        } catch (IOException e) {
            return new RespDTO("success",e.getMessage());
        }
    }


}
