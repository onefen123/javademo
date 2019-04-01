package com.zsgc.comtroller;


import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zsgc.config.SocketMsg;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint(value = "/websocket/{name}")
@Component
public class MyWebSocket {
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet=new CopyOnWriteArraySet<MyWebSocket>();
    private static Map<String,Session> map=new HashMap<String,Session>();
    private Session session;
    private String name;
    @OnOpen
    public void onOpen(Session session, @PathParam("name")String name){
        this.session=session;
        this.name=name;
        map.put(session.getId(),session);
        webSocketSet.add(this);
        System.out.println(session);
        this.session.getAsyncRemote().sendText(name+"上线!频道号:"+session.getId() +"在线人数"+webSocketSet.size()+"<br>");

    }
    @OnClose
    public void onClose(Session session){
        webSocketSet.remove(this);
        map.remove(session.getId(),session);
    }

    @OnMessage
    public void onMessage(String message,Session session, @PathParam("name")String name) throws IOException {

        try{
            SocketMsg socketMsg=new ObjectMapper().readValue(message,SocketMsg.class);
            if(socketMsg.getType()==0){
                broadcast(socketMsg,name);
            }else {
                socketMsg.setFromUser(session.getId());
                Session fromSession=map.get(socketMsg.getFromUser());
                Session toSession=map.get(socketMsg.getToUser());
                if(toSession!=null){
                    fromSession.getAsyncRemote().sendText(name+":"+socketMsg.getMsg());
                    toSession.getAsyncRemote().sendText(name+":"+socketMsg.getMsg());
                }else {
                    fromSession.getAsyncRemote().sendText("系统消息:对方不在线,或频道号不对!");
                }
            }
        }catch (JsonParseException e){
            e.printStackTrace();
        }catch (JsonMappingException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }



    }

    public void onError(Session session,Throwable error){
        System.out.println("Error!");
    }
    private void broadcast(SocketMsg socketMsg,String name){
        for (MyWebSocket item:webSocketSet){
            item.session.getAsyncRemote().sendText(name+":"+ socketMsg.getMsg()+"<br>");
        }
    }

}
