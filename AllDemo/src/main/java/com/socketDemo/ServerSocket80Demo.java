package com.socketDemo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by sunchong on 2016/12/22.
 */
public class ServerSocket80Demo{

    static ServerSocket serverSocket = null;

    public static void main(String[] args){
        listen();
    }

    public static void listen(){
        try{
            System.out.println("开始监听");
            serverSocket = new ServerSocket(80);
            Socket socket = serverSocket.accept();     //从连接请求队列中取出一个连接
            System.out.println("New connection accepted " +
                    socket.getInetAddress() + ":" + socket.getPort());
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
