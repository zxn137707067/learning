package com.hservice.grpc.server;

import com.hservice.grpc.schema.*;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

import java.util.logging.Logger;

@GrpcService(GreeterGrpc.class)
public  class GrpcServerService extends GreeterGrpc.GreeterImplBase  {
    private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());
    @Override
    public void sayHello(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        logger.info("welcome , " + req.getName());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    @Override
    public void sayHelloAgain(HelloRequest req, StreamObserver<HelloReply> responseObserver) {
        logger.info("welcome again, " + req.getName());
        HelloReply reply = HelloReply.newBuilder().setMessage("Hello again " + req.getName()).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
    @Override
    public void getData(HelloRequest request,
                        StreamObserver<HelloReplyUpdate> responseObserver) {

        logger.info("Welcome " + request.getName());
        //get data from DB
        HelloReplyObject helloReplyObject =HelloReplyObject.newBuilder().setName("Zhang,Xiaonan").setId("610375").build();

        HelloReplyUpdate reply = HelloReplyUpdate.newBuilder().setMessage("welcome again " + request.getName()).setHelloReplyObject(helloReplyObject).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();

    }
}