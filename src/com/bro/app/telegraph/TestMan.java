package com.bro.app.telegraph;

import net.sf.jcarrierpigeon.WindowPosition;

public class TestMan {

	public static void main(String[] args) {
		Telegraph telegraph = new Telegraph("Hello", "Yo ma", TelegraphType.NOTIFICATION_HELP, WindowPosition.BOTTOMRIGHT, 5000);
		telegraph.animate();
	}

}
