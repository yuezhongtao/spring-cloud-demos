package com.spring5.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public @ResponseBody String test(){
        return "test";
    }

}
