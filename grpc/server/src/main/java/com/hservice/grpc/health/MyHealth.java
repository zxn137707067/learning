package com.hservice.grpc.health;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo;
import feign.Param;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;
@Component("myHealth")
public class MyHealth implements HealthIndicator {

    private static final Logger logger = Logger.getLogger(MyHealth.class.getName());
//    @Override
//    public InstanceInfo.InstanceStatus getStatus(InstanceInfo.InstanceStatus instanceStatus) {
//
//        logger.info("XXXXXXX"+instanceStatus.toString());
//        return InstanceInfo.InstanceStatus.UP;
//    }

    private boolean up=true;

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    @Override
    public Health health() {

        if(up) {
            logger.info("XXXXXXX");
            return new Health.Builder().withDetail("aaa-", "up").up().build();
        }else{
            return new Health.Builder().withDetail("error-", "down").down().build();
        }
    }
}
