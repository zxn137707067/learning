package com.hservice.grpc.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageTest implements Serializable{

    private List<Object> list =new ArrayList<Object>();


    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
