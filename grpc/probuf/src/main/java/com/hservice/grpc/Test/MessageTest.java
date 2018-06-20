package com.hservice.grpc.Test;

import java.io.Serializable;

public class MessageTest implements Serializable{

    private String message;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
