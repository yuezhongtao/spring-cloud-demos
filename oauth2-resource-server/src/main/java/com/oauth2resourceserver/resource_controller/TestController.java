package com.oauth2resourceserver.resource_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/resource")
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    Map<String,String> test(){
        Map<String,String> map = new HashMap<>();
        map.put("result","success-resource-server");
        return map;
    }

}
