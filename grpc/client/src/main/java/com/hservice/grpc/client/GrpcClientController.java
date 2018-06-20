package com.hservice.grpc.client;

import com.hservice.grpc.api.Play;
import com.hservice.grpc.entity.ResponstObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


@RestController
public class GrpcClientController {

    private static final Logger logger = Logger.getLogger(GrpcClientController.class.getName());

    @Autowired
    private GrpcClientService grpcClientService;


    @Autowired
    private Play play;

    @RequestMapping("/sayHello")
    public String printMessage(@RequestParam(defaultValue = "ZXN") String name) {
        return grpcClientService.sendMessage(name);
    }

    @RequestMapping("/play")
    public String play(@RequestParam(defaultValue = "ZXN") String name) {

        logger.info( play.playPCGame(name));
        logger.info( play.playBall(name));
        return  "success!";

    }

    @RequestMapping("/test")
    public @ResponseBody ResponstObject test(@RequestParam(defaultValue = "ZXN") String name) {

        ResponstObject ro =new ResponstObject();
        ro.setM(1223);
        ro.setT("zhang");
        return  ro;

    }

    @GetMapping("/person/{id}")
    public @ResponseBody
    ResponseEntity< String > getPersonById(@PathVariable String id) {
        return new ResponseEntity < String > ("Response from GET with id " + id, HttpStatus.OK);
    }


}