package com.jewelry.web.controller.pay.wechat;


import com.jewelry.web.controller.pay.wechat.utils.FastJsonUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/webSocket/{myId}")
public class Websocket {
	 	private Session session;

	    private String myId;

	    private static CopyOnWriteArraySet<Websocket> webSocketSet=new CopyOnWriteArraySet<>();


	    @OnOpen
	    public void onopen(@PathParam("myId") String myId,
	                       Session session){
	        System.out.println("id:"+myId);
	        this.session=session;
	        this.myId=myId;
	        webSocketSet.add(this);
	        System.out.printf("[websocket消息]，有新的连接，总数：{}"+webSocketSet.size()+"id:"+myId);
	    }

	    @OnClose
	    public void onClose(){
	        webSocketSet.remove(this);
	        System.out.println("[websocket消息]，断开连接,总数{}"+webSocketSet.size());
	    }

	    @OnMessage
	    public void onMessage(String msg){
	    	System.out.println("[websocket消息]，客户端发来消息：{}"+msg);
	        //sendMessage(msg);
	    }


	    public void sendMessage(Object msg,String toid){

    		for(Websocket w:webSocketSet){
    			if(w.getMyId().equals(toid)){
    				try {
						w.getSession().getBasicRemote().sendText(FastJsonUtils.toJSONString(msg));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
    		}
	    }
	    
	    

		public Session getSession() {
			return session;
		}

		public void setSession(Session session) {
			this.session = session;
		}

		public String getMyId() {
			return myId;
		}

		public void setMyId(String myId) {
			this.myId = myId;
		}

		public static CopyOnWriteArraySet<Websocket> getWebSocketSet() {
			return webSocketSet;
		}

		public static void setWebSocketSet(CopyOnWriteArraySet<Websocket> webSocketSet) {
			Websocket.webSocketSet = webSocketSet;
		}
	    
	    
	    


}
