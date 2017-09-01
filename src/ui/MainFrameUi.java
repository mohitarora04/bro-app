package ui;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;

import javax.swing.JFrame;

public class MainFrameUi extends JFrame {

	private static final long serialVersionUID = 3129967103568722792L;
	private static MainFrameUi mainFrame;
	private static Object lock = new Object();
	private static final int FRAME_WIDTH = 200;
	private static final int FRAME_HEIGHT = 390;
	private static Vector<String> bros;
	
	public static MainFrameUi newMainFrameUi() {
		if (mainFrame == null) {
            synchronized (lock) {
                if (mainFrame == null) {
                	mainFrame = new MainFrameUi();
                }
            }
        }
		return mainFrame;
	}
	
	public void initMainFrame(Vector<String> brosList) {
		mainFrame.setUndecorated(true);
		mainFrame.setShape(new RoundRectangle2D.Double(10, 10, 400, 350, 100, 100));
		mainFrame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		mainFrame.setResizable(false);
		mainFrame.setLayout(new GridLayout(3, 1));
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - 250;
        int y = (int) rect.getMaxY() - 800;
        mainFrame.setLocation(x, y);
        bros = brosList;
	}

	public Vector<String> getBros() {
		return bros;
	}
}
