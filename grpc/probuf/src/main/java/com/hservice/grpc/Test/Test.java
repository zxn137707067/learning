package com.hservice.grpc.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.hservice.grpc.schema.HelloRequest;
import com.hservice.grpc.schema.HelloRequestInt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Test {

    public static void main(String args[]) {

//        try {
        // System.out.print("hello".getBytes("ascii")[0]);

        MessageTest a =new MessageTest();
        a.setMessage("hello");


        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        Gson g =new Gson();

        try {
            ObjectOutputStream oos=new ObjectOutputStream(baos);
            oos.writeObject(g.toJson(a));

          //  System.out.println(Arrays.toString(baos.toByteArray()));
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HelloRequest request = HelloRequest.newBuilder().setName("hello").build();
        byte[] byteArray1 = request.toByteArray();

        HelloRequestInt requestInt = HelloRequestInt.newBuilder().setName(300).build();
        byte[] byteArray2 = requestInt.toByteArray();
        // 把 HelloRequest 序列化为 byte[]字节数组
        System.out.println(Arrays.toString(byteArray1));// (field_number << 3) | wire_type :length :value
        System.out.println(Arrays.toString(byteArray2));
        //   System.out.println(new String(byteArray1));

        System.out.println(1 << 3| 2);  //10 , 5= length
        System.out.println(1 << 3| 0);

        //System.out.println(Integer.toBinaryString(-84));//11111111111111111111111110101100

       // System.out.println(Integer.toBinaryString(2));

        // System.out.println(Arrays.toString("name".getBytes()));
      //  System.out.println(Arrays.toString(request.getNameBytes().toByteArray()));
     //   System.out.println(Arrays.toString("{'message':'hello'}".getBytes()));

//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

    }
}
