package com.servicea.controller.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@FeignClient("service-b")
public interface ServiceBClient {

    @RequestMapping(value = "/test/b",method = RequestMethod.GET)
    @ResponseBody
    Map<String,Object> test();

}
