package com.zsgc.comtroller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet=new CopyOnWriteArraySet<>();
    private Session session;
    @OnOpen
    public void onOpnen(Session session){
        this.session=session;
        webSocketSet.add(this);
        this.session.getAsyncRemote().sendText("成功连接!--当前在线"+webSocketSet.size());

    }
    @OnClose
    public void onClose(Session session){
        webSocketSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message,Session session){
        broadcast(message);

    }

    public void onError(Session session,Throwable error){
        System.out.println("Error!");
    }
    private void broadcast(String message){
        for (MyWebSocket item:webSocketSet){
            item.session.getAsyncRemote().sendText(message);
        }
    }

}
