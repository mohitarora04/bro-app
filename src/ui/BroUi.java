package ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JTextArea;

import com.bro.app.BootSocket;

@SuppressWarnings("resource")
public class BroUi {
	
	private static Map<String, List<String>> groups = new HashMap<String, List<String>>();
	private static Vector<String> bros = null;
	JTextArea textArea;
	static Rectangle rect;

	static {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
	        rect = defaultScreen.getDefaultConfiguration().getBounds();
	        populateGroup(Constants.LUNCH, Constants.LUNCH_GROUP);
	        populateGroup(Constants.TT, Constants.TT_GROUP);
	        populateGroup(Constants.CAB, Constants.CAB_GROUP);
	        populateGroup(Constants.WALK, Constants.AFTERLUNCHWALK_GROUP);
	        populateGroup(Constants.STAND_UP, Constants.STANDUP);
	        bros = new Vector<String>();
	        bros.add("Select a 'BRO'");
	        if (new File(Constants.FILE_LOC + "broApp.txt").exists()) {
	        	FileReader fr = new FileReader(Constants.FILE_LOC + "broApp.txt");
		        BufferedReader br = new BufferedReader(fr);
		        String member;
		        while ((member = br.readLine()) != null) {
		        	bros.add(member);
		        }
	        }
	    } catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void populateGroup(String groupName, String groupFile) throws Exception {
		if (new File(groupFile).exists()) {
			FileReader fr = new FileReader(groupFile);
	        BufferedReader br = new BufferedReader(fr);
	        String member;
	        List<String> membersList;
	        while ((member = br.readLine()) != null) {
	        	if (groups.containsKey(groupName)) {
	        		membersList = groups.get(groupName);
	        	} else {
	        		membersList = new ArrayList<String>();
	        	}
	        	membersList.add(member);
	        	groups.put(groupName, membersList);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		MainFrameUi mainFrame = MainFrameUi.newMainFrameUi();
		MainFramePanel controlPanel = MainFramePanel.newMainFramePanel();
		mainFrame.initMainFrame(bros);
		controlPanel.initPanelConfig(mainFrame, groups, bros);
		BootSocket.start();
	}
}
