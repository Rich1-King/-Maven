package com.socketDemo;

import java.io.*;
import java.net.Socket;

/**
 * Created by rich1 on 9/3/17.
 * 不同语言socket通信,整形是解析不了的
 */
public class Client{

    public static void main(String[] args){

        try{
            Socket socket = new Socket("localhost", 2541);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write(200);
            writer.flush();
            writer.close();
            socket.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
