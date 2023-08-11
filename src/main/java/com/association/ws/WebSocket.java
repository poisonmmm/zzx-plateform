package com.association.ws;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * ws操作相关服务
 *
 * @author LUMING
 * @since 2023/8/11 10:34
 */
@Component
@Slf4j
@ServerEndpoint("/websocket/{id}")  // 接口路径 ws://localhost:8080/websocket/id;

public class WebSocket {

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    /**
     * 用户ID
     */
    private String id;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    //虽然@Component默认是单例模式的，但springboot还是会为每个websocket连接初始化一个bean，所以可以用一个静态set保存起来。
    //  注：底下WebSocket是当前类名
    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();
    // 用来存在线连接用户信息
    private static ConcurrentHashMap<String, Session> sessionPool = new ConcurrentHashMap<String, Session>();



    /**
     * 链接成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "id") String id) {
        try {
            this.session = session;
            this.id = id;
            webSockets.add(this);
            sessionPool.put(id, session);

            log.info("【websocket消息】有新的连接，总数为:" + webSockets.size());
            System.out.print("id:[");
            int index=0;
            for (WebSocket webSocket : webSockets) {
                index++;
                System.out.printf(webSocket.id);
                if (index<webSockets.size()){
                    System.out.print(",");
                }
            }
            System.out.print("] \n");
        } catch (Exception e) {
        }
    }

    /**
     * 链接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        try {
            webSockets.remove(this);
            sessionPool.remove(this.id);
            log.info("【websocket消息】连接断开，总数为:" + webSockets.size());
        } catch (Exception e) {
        }
    }


    /**
     * 收到客户端消息后调用的方法
     */
    @OnMessage
    public void onMessage(String message) {
        String currentId = id;
        HashMap<String, String> map = (HashMap<String, String>) JSONObject.parseObject(message, HashMap.class);
        map.put("from", currentId);
        String to = map.get("to");
        message = JSONObject.toJSONString(map);
        sendOneMessage(to, message);
        sendOneMessage(currentId, message);
    }


    // 此为单点消息
    public void sendOneMessage(String id, String message) {
        Session session = sessionPool.get(id);
        if (session != null && session.isOpen()) {
            try {
                HashMap<String, String> map = (HashMap<String, String>) JSONObject.parseObject(message, HashMap.class);
                String msg = map.get("msg");
                session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发送错误时的处理
     */
    @OnError
    public void onError(Session session, Throwable error) {

        log.error("用户错误,原因:" + error.getMessage());
        error.printStackTrace();
    }


}