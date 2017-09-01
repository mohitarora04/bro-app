package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.bro.app.interfaces.BroService;
import com.bro.app.service.StandardBroService;

public class MainFramePanel extends JPanel {

	private static final long serialVersionUID = 403038778011123339L;
	private static Object lock = new Object();
	private static MainFramePanel controlPanel;
	private static String selectedBro;
	private static JComboBox<String> broList;
	
	public static MainFramePanel newMainFramePanel() {
		if (controlPanel == null) {
            synchronized (lock) {
                if (controlPanel == null) {
                	controlPanel = new MainFramePanel();
                }
            }
        }
		return controlPanel;
	}
	
	public void initPanelConfig(JFrame frame, Map<String, List<String>> groups, Vector<String> bros) throws Exception {
		BroService broService = StandardBroService.newBroService();
		controlPanel.setLayout(null);
		controlPanel.setOpaque(true);
		controlPanel.setSize(180, 180);
		
		//JButton broSign = CommonHelper.addImageIconOnButton(BRO_BUTTON, BRO_TOOL_TIP, 20, 20, 30, 30);
	    JButton closeButton = CommonHelper.addImageIconOnButton(Constants.CLOSE_BUTTON, Constants.CLOSE_TOOL_TIP, 185, 20, 10, 10);
	    closeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
				System.exit(0);
			}
		});
	    JButton lunchButton = CommonHelper.addImageIconOnButton(Constants.LUNCH_BUTTON, Constants.LUNCH_BUTTON_TOOLTIP, 20, 50, 30, 30);
	    lunchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (groups.containsKey(Constants.LUNCH)) {
					List<String> members = groups.get(Constants.LUNCH);
					for (String member : members) {
						broService.setBroPerson(member, "You have been BRO'ed for Lunch");
						broService.broSelectedBrother();
					}
				} else {
					broService.setBroPerson(selectedBro, "You have been BRO'ed for Lunch");
					broService.broSelectedBrother();
				}
			}
		});
	    JButton snacksButton = CommonHelper.addImageIconOnButton(Constants.SNACKS_BUTTON, Constants.SNACKS_BUTTON_TOOLTIP, 20, 95, 30, 30);
	    snacksButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (groups.containsKey(Constants.SNACKS)) {
					List<String> members = groups.get(Constants.SNACKS);
					for (String member : members) {
						broService.setBroPerson(member, "You have been BRO'ed for Lunch");
						broService.broSelectedBrother();
					}
				} else {
					broService.setBroPerson(selectedBro, "You have been BRO'ed for Lunch");
					broService.broSelectedBrother();
				}
			}
		});
	    JButton meetingButton = CommonHelper.addImageIconOnButton(Constants.MEETING_BUTTON, Constants.MEETING_BUTTON_TOOLTIP, 20, 140, 30, 30);
	    meetingButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (groups.containsKey(Constants.STAND_UP)) {
					List<String> members = groups.get(Constants.STAND_UP);
					for (String member : members) {
						broService.setBroPerson(member, "You have been BRO'ed for Lunch");
						broService.broSelectedBrother();
					}
				} else {
					broService.setBroPerson(selectedBro, "You have been BRO'ed for Lunch");
					broService.broSelectedBrother();
				}
			}
		});
	    JButton walkButton = CommonHelper.addImageIconOnButton(Constants.WALK_BUTTON, Constants.WALK_BUTTON_TOOLTIP, 20, 185, 30, 30);
	    walkButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (groups.containsKey(Constants.WALK)) {
					List<String> members = groups.get(Constants.WALK);
					for (String member : members) {
						broService.setBroPerson(member, "You have been BRO'ed for Lunch");
						broService.broSelectedBrother();
					}
				} else {
					broService.setBroPerson(selectedBro, "You have been BRO'ed for Lunch");
					broService.broSelectedBrother();
				}
			}
		});
	    JButton birthdayButton = CommonHelper.addImageIconOnButton(Constants.HAPPY_BIRTHDAY_BUTTON, Constants.HAPPY_BIRTHDAY_BUTTON_TOOLTIP, 20, 230, 30, 30);
	    birthdayButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				broService.setBroPerson(selectedBro, "You have been BRO'ed for Birthday");
				broService.broSelectedBrother();
			}
		});
	    JButton homeButton = CommonHelper.addImageIconOnButton(Constants.HOME_BUTTON, Constants.HOME_BUTTON_TOOLTIP, 20, 280, 30, 30);
	    homeButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (groups.containsKey(Constants.CAB)) {
					List<String> members = groups.get(Constants.CAB);
					for (String member : members) {
						broService.setBroPerson(member, "You have been BRO'ed for Lunch");
						broService.broSelectedBrother();
					}
				} else {
					broService.setBroPerson(selectedBro, "You have been BRO'ed for Lunch");
					broService.broSelectedBrother();
				}
			}
		});
	    JButton ttButton = CommonHelper.addImageIconOnButton(Constants.TT_GROUPNAME, Constants.TT_GROUP_TOOLTIP, 140, 142, 30, 30);
	    ttButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (groups.containsKey(Constants.TT)) {
					List<String> members = groups.get(Constants.TT);
					for (String member : members) {
						broService.setBroPerson(member, "You have been BRO'ed for Lunch");
						broService.broSelectedBrother();
					}
				} else {
					broService.setBroPerson(selectedBro, "You have been BRO'ed for Lunch");
					broService.broSelectedBrother();
				}
			}
		});
	    JButton helpButton = CommonHelper.addImageIconOnButton(Constants.HELP_BUTTON, Constants.HELP_BUTTON_TOOLTIP, 80, 98, 30, 30);
	    helpButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				broService.setBroPerson(selectedBro, "You have been BRO'ed for Help");
				broService.broSelectedBrother();
			}
		});
	    JButton suttaButton = CommonHelper.addImageIconOnButton(Constants.SUTTA_BUTTON, Constants.SUTTA_BUTTON_TOOLTIP, 80, 142, 30, 30);
	    suttaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				broService.setBroPerson(selectedBro, "You have been BRO'ed for Sutta");
				broService.broSelectedBrother();
			}
		});
	    JButton teaButton = CommonHelper.addImageIconOnButton(Constants.TEA_BUTTON, Constants.TEA_BUTTON_TOOLTIP, 80, 183, 30, 30);
	    teaButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				broService.setBroPerson(selectedBro, "You have been BRO'ed for Tea");
				broService.broSelectedBrother();
			}
		});
	    JButton caromButton = CommonHelper.addImageIconOnButton(Constants.CAROM_BUTTON, Constants.CAROM_BUTTON_TOOLTIP, 80, 230, 30, 30);
	    caromButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				broService.setBroPerson(selectedBro, "You have been BRO'ed for Caram");
				broService.broSelectedBrother();
			}
		});
	    JButton outsideLunchButton = CommonHelper.addImageIconOnButton(Constants.LUNCH_OUTSIDE_BUTTON, Constants.LUNCH_OUTSIDE_BUTTON_TOOLTIP, 140, 183, 30, 30);
	    outsideLunchButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				broService.setBroPerson(selectedBro, "You have been BRO'ed for lunch outside");
				broService.broSelectedBrother();
			}
		});
	    JButton addBroButton = CommonHelper.addImageIconOnButton(Constants.ADD_BRO_BUTTON, Constants.ADD_BRO_BUTTON_TOOLTIP, 163, 325, 30, 30);
	    addBroButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HostDialog.launchHostDialog(frame, groups);
			}
		});
	    JButton quickChatButton = CommonHelper.addImageIconOnButton(Constants.CHAT_BUTTON, Constants.CHAT_BUTTON_TOOLTIP, 120, 325, 30, 30);
	    quickChatButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				initiateChat();
			}

			private void initiateChat() {}
		});
	    Vector<String> list = new Vector<String>(bros);
	    broList = new JComboBox<>(list);
	    broList.setSize(120, 20);
	    broList.setLocation(50, 17);
	    broList.addActionListener(new ActionListener() {
			@SuppressWarnings("rawtypes")
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedBro = ((JComboBox) e.getSource()).getSelectedItem().toString();
			}
		});
	    controlPanel.add(broList);
		controlPanel.add(quickChatButton);
		controlPanel.add(caromButton);
		controlPanel.add(outsideLunchButton);
		controlPanel.add(teaButton);
		controlPanel.add(suttaButton);
		controlPanel.add(ttButton);
		controlPanel.add(helpButton);
		controlPanel.add(homeButton);
		controlPanel.add(addBroButton);
		controlPanel.add(birthdayButton);
		controlPanel.add(walkButton);
		controlPanel.add(closeButton);
		controlPanel.add(lunchButton);
		controlPanel.add(snacksButton);
		controlPanel.add(meetingButton);
		controlPanel.setOpaque(true);
		controlPanel.setBorder(new LineBorder(new Color(200, 0, 0)));
		//controlPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		//controlPanel.setBackground(new Color(213, 134, 115, 10));
		controlPanel.setBackground(new Color(150, 100, 100, 100));
		frame.getContentPane().setBackground(Color.WHITE.darker());
		frame.setContentPane(controlPanel);
		frame.setVisible(true);
	}
	
	public void add(String member) {
		broList.addItem(member);
	}
}
