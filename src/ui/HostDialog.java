package ui;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class HostDialog extends Dialog {

	private static final long serialVersionUID = 411943365200202321L;
	
	private HostDialog(Dialog owner) {
		super(owner);
	}
	
	public static void launchHostDialog(JFrame mainFrame, Map<String, List<String>> groups) {
		Dialog d1=new Dialog(mainFrame);
		d1.setTitle("Add bro");        
		d1.setSize(200,30);
		d1.setUndecorated(true);       
		d1.setBackground(Color.GRAY);        
		d1.setOpacity(0.4f);        
		d1.setLocationRelativeTo(null);
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - 250;
        int y = (int) rect.getMaxY() - 430;
        d1.setLocation(x, y);
        JTextField hostName = new JTextField();
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        hostName.setBorder(border);
        Action action = new AbstractAction()
        {
            private static final long serialVersionUID = 5301065035548521714L;

			@Override
            public void actionPerformed(ActionEvent e)
            {
				GroupsPanel.newGroupsPanel().launchGroupPanel(hostName.getText(), d1, groups);
            }
        };
        hostName.addActionListener(action);
        d1.add(hostName);
        d1.setVisible(true);
	}
}
