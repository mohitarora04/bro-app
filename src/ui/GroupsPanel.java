package ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class GroupsPanel extends JPanel {

	private static final long serialVersionUID = -3529510823715741599L;
	private static Object lock = new Object();
	private static GroupsPanel groupPanel;
	private static MainFrameUi mainUiFrame;
	private static MainFramePanel mainPanel;
	
	public static GroupsPanel newGroupsPanel() {
		if (groupPanel == null) {
            synchronized (lock) {
                if (groupPanel == null) {
                	groupPanel = new GroupsPanel();
                }
            }
        }
		mainUiFrame = MainFrameUi.newMainFrameUi();
		mainPanel = MainFramePanel.newMainFramePanel();
		return groupPanel;
	}
	
	public void launchGroupPanel(String member, Dialog parent, Map<String, List<String>> groups) {
		try{
			Map<String, String> selectedGroups = new HashMap<String, String>();
			String bro = member;
			Vector<String> bros = mainUiFrame.getBros();
			boolean add = true;
			if (null != bros) {
				for (int i=0; i < bros.size(); i++) {
					String innerBro = bros.get(i);
					if (innerBro.equals(bro)) {
						add = false;
						break;
					}
				}
			} else {
				bros = new Vector<String>();
			}
			if (add) {
				bros.add(bro);
			}
			mainPanel.add(bro);
			writeToFile(Constants.FILE_LOC + "broApp.txt", bro);
			parent.dispose();
            JFrame mainFrame = new JFrame();
    		mainFrame.setUndecorated(true);
    		mainFrame.setSize(200, 170);
    		mainFrame.setResizable(false);
    		mainFrame.setLayout(new GridLayout(3, 1));
    		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
            Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    		int x = (int) rect.getMaxX() - 250;
            int y = (int) rect.getMaxY() - 430;
            mainFrame.setLocation(x, y);
            JPanel controlPanel = new JPanel();
    		controlPanel.setLayout(null);
    		controlPanel.setOpaque(true);
    		controlPanel.setSize(180, 90);
    		
    		JButton lunchButton = CommonHelper.addImageIconOnButton(Constants.LUNCH_BUTTON, "Lunch Group", 10, 50, 25, 25);
    	    lunchButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				lunchButton.setBackground(Color.GREEN);
    				selectedGroups.put("Lunch", Constants.LUNCH_GROUP);
    			}
    		});
    	    JButton snacksButton = CommonHelper.addImageIconOnButton(Constants.SNACKS_BUTTON, "Snacks Group", 50, 50, 25, 25);
    	    snacksButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				snacksButton.setBackground(Color.GREEN);
    				selectedGroups.put("Snacks", Constants.SNACKS_GROUP);
    			}
    		});
    	    JButton meetingButton = CommonHelper.addImageIconOnButton(Constants.MEETING_BUTTON, "Meet Group", 90, 50, 25, 25);
    	    meetingButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				meetingButton.setBackground(Color.GREEN);
    				selectedGroups.put("StandUp", Constants.STANDUP);
    			}
    		});
    	    JButton walkButton = CommonHelper.addImageIconOnButton(Constants.WALK_BUTTON, "After Lunch Walk Group", 130, 50, 25, 25);
    	    walkButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				walkButton.setBackground(Color.GREEN);
    				selectedGroups.put("Walk", Constants.AFTERLUNCHWALK_GROUP);
    			}
    		});
    	    JButton homeButton = CommonHelper.addImageIconOnButton(Constants.HOME_BUTTON, "Home Group", 170, 50, 25, 25);
    	    homeButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				homeButton.setBackground(Color.GREEN);
    				selectedGroups.put("Cab", Constants.CAB_GROUP);
    			}
    		});
    	    JButton ttGroup = CommonHelper.addImageIconOnButton(Constants.TT_GROUPNAME, Constants.TT_GROUP_TOOLTIP, 10, 100, 25, 25);
    	    ttGroup.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				ttGroup.setBackground(Color.GREEN);
    				selectedGroups.put("TT", Constants.TT_GROUP);
    			}
    		});
    	    JButton addGroup = CommonHelper.addImageIconOnButton(Constants.GROUP, Constants.GROUP_TOOLTIP, 160, 130, 30, 30);
    	    addGroup.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				for (Entry<String, String> entry : selectedGroups.entrySet()) {
    					try {
							writeToFile(entry.getValue(), bro);
							List<String> members;
							String groupName = entry.getKey();
							if (groups.containsKey(groupName)) {
								members = groups.get(groupName);
							} else {
								members = new ArrayList<String>();
							}
							if (!members.contains(bro)) {
								members.add(bro);
							}
							groups.put(groupName, members);
							mainFrame.dispose();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
    				}
    			}
    		});
    	    MyButton skipButton = new MyButton("Skip");
    	    skipButton.setPressedBackgroundColor(Color.RED);
    	    skipButton.setHoverBackgroundColor(Color.GREEN);
    	    skipButton.setBorder(BorderFactory.createEmptyBorder());
    	    skipButton.setSize(new Dimension(30, 30));
    	    skipButton.setLocation(120, 130);
    	    skipButton.setToolTipText("Skip adding 'BRO' to any group");
    	    skipButton.addMouseListener(new MouseAdapter() {
    			@Override
    			public void mouseClicked(MouseEvent e) {
    				mainFrame.dispose();
    			}
    		});
    	    MyButton label = new MyButton("Add 'BRO' to group");
    	    label.setBorder(BorderFactory.createEmptyBorder());
    	    label.setHoverBackgroundColor(new Color(213, 134, 115, 10));
    	    label.setSize(new Dimension(120, 20));
    	    label.setLocation(5, 10);
    	    controlPanel.add(label);
    	    controlPanel.add(skipButton);
    	    controlPanel.add(addGroup);
    	    controlPanel.add(lunchButton);
    	    controlPanel.add(snacksButton);
    	    controlPanel.add(meetingButton);
    	    controlPanel.add(walkButton);
    	    controlPanel.add(ttGroup);
    	    controlPanel.add(homeButton);
    	    controlPanel.setOpaque(true);
    		controlPanel.setBorder(new LineBorder(new Color(10, 0, 0)));
    		controlPanel.setBackground(new Color(150, 100, 100, 100));
    	    mainFrame.setContentPane(controlPanel);
    	    mainFrame.setVisible(true);
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
	}
	
	private void writeToFile(String fileLoc, String content) throws IOException {
		File file = new File(fileLoc);                
        FileWriter fw = new FileWriter(file,true);     
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(content);
        bw.newLine();
        bw.flush();
        bw.close();
	}
}
