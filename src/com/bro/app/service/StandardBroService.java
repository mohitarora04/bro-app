package com.bro.app.service;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.bro.app.interfaces.BroService;
import com.bro.app.socket.config.InitSocketConfigs;

public class StandardBroService implements BroService, Runnable {
	
	private static InitSocketConfigs initSocketConfig;
	private static ServerSocket serverBroSocket;
	private static String broPerson;
	private static Object lock = new Object();
	private static BroService broService;
	private static String message;
	
	static {
		try {
			initSocketConfig = InitSocketConfigs.newInitSocketConfigs();
			serverBroSocket = initSocketConfig.getServerSocketlistenerForBroing();
			if (broService == null) {
	            synchronized (lock) {
	                if (broService == null) {
	                	broService = new StandardBroService();
	                }
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private StandardBroService() {}
	
	public static BroService newBroService() throws IOException {
		return broService;
	}

	@Override
	public void broSelectedBrother() {
		try {
			Socket socket;
			if (broPerson != "All") {
				socket = initSocketConfig.getSocketToBro(broPerson);
				OutputStream ostream = socket.getOutputStream();                 
			    DataOutputStream dos = new DataOutputStream(ostream);
			    dos.writeBytes(message);                                                         
			    dos.close();                            
			    ostream.close();   
			    socket.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void listenForBro() throws Exception {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void displayTray(String message) throws Exception {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/storage/home.png"));
		// Alternative (if the icon is on the classpath):
		// Image image =
		// Toolkit.getToolkit().createImage(getClass().getResource("icon.png"));
		TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip("System tray icon demo");
		tray.add(trayIcon);
		trayIcon.displayMessage(message, "PTC BRO", MessageType.INFO);
	}
	
	@Override
	public String getBroPerson() {
		return broPerson;
	}
	
	@Override
	public void setBroPerson(String broPerson, String message) {
		StandardBroService.broPerson = broPerson;
		StandardBroService.message = message;
	}

	@Override
	public void run() {
		try {
			while(true)
			{
				Socket sock = serverBroSocket.accept( );                          
		        InputStream istream = sock.getInputStream();
				BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
				String receiveMessage;            
				if((receiveMessage = receiveRead.readLine()) != null)  
				{
					displayTray(receiveMessage);         
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
