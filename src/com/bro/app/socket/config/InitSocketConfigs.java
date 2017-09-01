package com.bro.app.socket.config;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class InitSocketConfigs {
	
	private static Object lock = new Object();
	private static InitSocketConfigs initSocketConfig;
	private static ServerSocket serverSocketBroing;
	private static final int PORT = 1100;
	 
	static {
		if (initSocketConfig == null) {
            synchronized (lock) {
                if (initSocketConfig == null) {
                	initSocketConfig = new InitSocketConfigs();
                }
            }
        }
    }
	
	private InitSocketConfigs() {};
	
	public static InitSocketConfigs newInitSocketConfigs() throws IOException {
		serverSocketBroing = new ServerSocket(PORT);
		serverSocketBroing.setReuseAddress(true);
		return initSocketConfig;
	}
	
	public ServerSocket getServerSocketlistenerForBroing() {
		return serverSocketBroing;
	}
	
	public Socket getSocketToBro(String broId) throws Exception {
		Socket sock = new Socket(broId, PORT);
		return sock;
	}

}
