package com.weebkun.skipdq_net;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;

public class WSClient extends WebSocketClient {

    private static WSClient client;

    static {
        try {
            client = new WSClient(new URI("ws://skipdq.herokuapp.com"));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public WSClient(URI serverUri) {
        super(serverUri);
    }

    public void addHeader(String key, String value) {
        super.addHeader(key, value);
    }

    @Override
    public void onOpen(ServerHandshake handshake) {
        System.out.println("connection opened");
    }

    @Override
    public void onMessage(String message) {
        System.out.println(String.format("WS: %s", message));
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {

    }

    @Override
    public void onError(Exception ex) {

    }

    public void connect(String id) {
        super.connect();
        new Thread(() -> {
            while(true) {
                if(isOpen()) {
                    // send user id to server
                    send(String.format("{" +
                            "\"message\":\"register_socket\"" +
                            "\"id\": \"%s\"" +
                            "}", id));
                    break;
                }
            }
            while (true) {
                // send a ping frame every 30 sec
                if (isOpen()) {
                    sendPing();
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static WSClient getClient() {
        return client;
    }
}
