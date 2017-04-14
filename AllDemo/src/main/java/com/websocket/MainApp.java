package com.websocket;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;

/**
 * Created by rich1 on 4/14/17.
 */
public class MainApp{

    public Session session;

    private void start(){
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "ws://localhost:8080/ws/demo";
        System.out.println("Connection to"+uri);
        try{
            session = container.connectToServer(WebSocketClient.class, URI.create(uri));
        }catch (IOException e){
            e.printStackTrace();
        }catch (DeploymentException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        System.out.println("开始");

        MainApp app = new MainApp();
        app.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        try{
            do{
                input = br.readLine();
                if(!"exit".equals(input)){
                    app.session.getBasicRemote().sendText(input);
                }
            }while (!input.equals("exit"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
