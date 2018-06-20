package com.zxn.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
@RestController
public class ConfigServerApplication {

//    @Value("${test.type}")
    private String name;
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }


    @RequestMapping("/test")
    public String test(){
        return name;
    }

}
