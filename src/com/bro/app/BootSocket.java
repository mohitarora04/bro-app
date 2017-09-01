package com.bro.app;

import com.bro.app.interfaces.BroService;
import com.bro.app.service.StandardBroService;

public class BootSocket {

	public static void start() throws Exception {
		System.out.println("Booting BRO...!");
		BroService broService = StandardBroService.newBroService();
		if (null != broService) {
			broService.listenForBro();
		}
	}

}
