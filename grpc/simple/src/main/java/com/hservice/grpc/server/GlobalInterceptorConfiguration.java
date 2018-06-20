package com.hservice.grpc.server;

import net.devh.springboot.autoconfigure.grpc.server.GlobalServerInterceptorConfigurerAdapter;
import net.devh.springboot.autoconfigure.grpc.server.GlobalServerInterceptorRegistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class GlobalInterceptorConfiguration {
    private static final Logger logger = Logger.getLogger(GlobalInterceptorConfiguration.class.getName());

    @Bean
    public GlobalServerInterceptorConfigurerAdapter globalInterceptorConfigurerAdapter() {



        return new GlobalServerInterceptorConfigurerAdapter() {
            @Override
            public void addServerInterceptors(GlobalServerInterceptorRegistry registry) {
                registry.addServerInterceptors(new LogGrpcInterceptor());
            }
        };
    }

}
