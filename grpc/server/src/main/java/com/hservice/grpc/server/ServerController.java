package com.hservice.grpc.server;


import com.hservice.grpc.api.Play;
import com.hservice.grpc.health.MyHealth;
import com.netflix.appinfo.ApplicationInfoManager;
import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class ServerController implements Play {


    private static final Logger logger = Logger.getLogger(ServerController.class.getName());

    @Autowired
    private MyHealth myHealth;

//    private ApplicationInfoManager applicationInfoManager;

    @Override
    public String playPCGame(String name) {
        logger.info("welcome to play PCGame, " + name);
        return name+ "　is playing PCGame!";
    }

    @Override
    public String playBall(String name) {

        logger.info("welcome to play Ball, " + name);
        return name+ "　is playing ball!";
    }
    @RequestMapping
    public String change(@RequestParam("status") Boolean status){
//        applicationInfoManager.getInfo().setStatus(InstanceInfo.InstanceStatus.DOWN);
        myHealth.setUp(status);

        return status.toString();
    }

    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " + discoveryClient.getServices();
//        String intstance = "Services: " + discoveryClient.getInstances("CLOUD-GRPC-SERVER");
        System.out.println(services);
//        System.out.println(intstance);
        return services;
    }

}
