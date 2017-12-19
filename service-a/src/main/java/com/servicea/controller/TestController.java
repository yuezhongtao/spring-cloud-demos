package com.servicea.controller;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> test(){
        Map<String,Object> map = Maps.newHashMap();
        map.put("result","success");
        return map;
    }
}
