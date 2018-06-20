package com.zxn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CotrollerTest {

    @Value("${type}")
    private String name;



    @RequestMapping("/test")
    public String test(){
        return name;
    }
}
