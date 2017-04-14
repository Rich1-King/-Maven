package com.websocket;

import javax.websocket.*;
import java.io.IOException;

/**
 * Created by rich1 on 4/14/17.
 */
@ClientEndpoint
public class WebSocketClient{

    @OnOpen
    public void onOpen(Session session){
        System.out.println("Connection to endpoint:"+session.getBasicRemote());

        try{
            session.getBasicRemote().sendText("Hello, meeting you");
        }catch (IOException e){

        }
    }

    @OnMessage
    public void onMessage(String message){
        System.out.println("recieve message:"+message);
    }

    @OnError
    public void onError(Throwable e){
        e.printStackTrace();
    }

}
