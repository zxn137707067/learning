package com.hservice.grpc.Test;

import com.google.gson.Gson;
import com.hservice.grpc.schema.HelloRequest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class Test {

    private String t ;

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public static void main(String args[]) {

//        try {
        // System.out.print("hello".getBytes("ascii")[0]);

        MessageTest a =new MessageTest();

        List list=a.getList();

        list .add("MMMM");
        Test test=new Test();
        test.setT("AAAA");
        list.add(test);
        Gson g =new Gson();
        System.out.println(g.toJson(list));
//        ByteArrayOutputStream baos=new ByteArrayOutputStream();
//
//
//        try {
//            ObjectOutputStream oos=new ObjectOutputStream(baos);
//            oos.writeObject(a);
//
//          //  System.out.println(Arrays.toString(baos.toByteArray()));
//            oos.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        HelloRequest request = HelloRequest.newBuilder().setName("hello").build();
//        byte[] byteArray1 = request.toByteArray();
        // 把 HelloRequest 序列化为 byte[]字节数组
       // System.out.println(Arrays.toString(byteArray1));// (field_number << 3) | wire_type :length :value
     //   System.out.println(new String(byteArray1));

        System.out.println(1 << 3| 2);  //10 , 5= length

       // System.out.println(Arrays.toString("name".getBytes()));
      //  System.out.println(Arrays.toString(request.getNameBytes().toByteArray()));
     //   System.out.println(Arrays.toString("{'message':'hello'}".getBytes()));

//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }
}
