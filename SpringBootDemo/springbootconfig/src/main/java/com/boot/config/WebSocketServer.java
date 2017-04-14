package com.boot.config;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by sunchong on 2017/3/20.
 */
@Component
@ServerEndpoint("/ws/demo")
public class WebSocketServer{

    private static int onlineCount = 0;

    private static CopyOnWriteArrayList<WebSocketServer> webSocketServers = new CopyOnWriteArrayList<>();

    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        webSocketServers.add(this);
        addOnlineCount();
        System.out.println("有新链接加入!当前在线人数为"+getOnlineCount());
    }

    @OnClose
    public void onClose(){
        webSocketServers.remove(this);
        subOnlineCount();
        System.out.println("有一个链接关闭!当前在线人数为"+getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session){
        System.out.println("来自客户端的信息:"+message);

        for(WebSocketServer server : webSocketServers){
            try{
                server.sendMessage(message);
            }catch (IOException e){
                e.printStackTrace();
                continue;
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error){
        System.out.println("发生错误");
        error.printStackTrace();
    }

    public static int getOnlineCount(){
        return onlineCount;
    }

    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized void addOnlineCount(){
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount(){
        WebSocketServer.onlineCount--;
    }

}
