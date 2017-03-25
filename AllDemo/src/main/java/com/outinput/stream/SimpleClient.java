package com.outinput.stream;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by rich1 on 2/21/17.
 */
public class SimpleClient{

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        ArrayList<String> strList = new ArrayList<String>();
        strList.add("aaa");
        strList.add("bbb");
        strList.add("ccc");
        System.out.println(strList.toString());
        ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(strList.toString().getBytes())));
        Object o = objectInputStream.readObject();
        System.out.println("over");

    }

}
