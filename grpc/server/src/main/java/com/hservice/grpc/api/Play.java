package com.hservice.grpc.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="cloud-grpc-server")
public interface Play {
    @GetMapping(value="/pc")
    public String playPCGame(@RequestParam("name") String name);
    @GetMapping(value="/ball")
    public String playBall(@RequestParam("name") String name);

}
