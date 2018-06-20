/*
 * Copyright 2015 The gRPC Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hservice.grpc.server;

import com.hservice.grpc.schema.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Server that manages startup/shutdown of a {@code Greeter} server.
 */
public class HelloWorldServer {
  private static final Logger logger = Logger.getLogger(HelloWorldServer.class.getName());


  public  class GreeterImpl extends GreeterGrpc.GreeterImplBase  {

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
}
