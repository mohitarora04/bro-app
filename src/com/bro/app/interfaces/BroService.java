package com.bro.app.interfaces;


public interface BroService {
	
	public void broSelectedBrother();
	
	public void listenForBro() throws Exception;
	
	public void displayTray(String message) throws Exception;
	
	public String getBroPerson();
	
	public void setBroPerson(String broPerson, String message);
}
