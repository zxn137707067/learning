package com.hservice.grpc.client;

import com.hservice.grpc.schema.GreeterGrpc;
import com.hservice.grpc.schema.HelloReply;
import com.hservice.grpc.schema.HelloReplyUpdate;
import com.hservice.grpc.schema.HelloRequest;

import io.grpc.StatusRuntimeException;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;

import io.grpc.Channel;

import java.util.logging.Level;
import java.util.logging.Logger;


@Service
public class GrpcClientService {

    private static final Logger logger = Logger.getLogger(HelloWorldClient.class.getName());


    @GrpcClient("cloud-grpc-server")
    private Channel serverChannel;


//    private Channel serverChannel= ManagedChannelBuilder.forAddress("127.0.0.1", 50051)
//            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
//            // needing certificates.
//            .usePlaintext(true)
//            .build();

    public String sendMessage(String name) {


        GreeterGrpc.GreeterBlockingStub blockingStub = GreeterGrpc.newBlockingStub(serverChannel)  ;
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloReply response;
        HelloReply response1;
        HelloReply response2;
        HelloReplyUpdate responseUpdate;
        try {

            response = blockingStub.sayHello(request);
//            response1=blockingStub.sayHelloAgain(request);
//            response2=blockingStub.sayHelloAgain(request);
            responseUpdate = blockingStub.getData(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "RPC failed: {0}", e.getStatus());
            return "{}";
        }

        logger.info("Greeting: " + responseUpdate.toString());

        return response.getMessage();
    }
}
