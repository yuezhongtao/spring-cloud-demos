package com.servicea.controller;

import com.google.common.collect.Maps;
import com.servicea.controller.feign.ServiceBClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private ServiceBClient serviceBClient;

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> test(){
        Map<String,Object> map = Maps.newHashMap();
        map = serviceBClient.test();
        return map;
    }
}
