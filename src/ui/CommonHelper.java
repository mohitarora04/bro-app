package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CommonHelper {
	
	public static JButton addImageIconOnButton(String iconResource, String tooltip, int locX, int locY, int width, int height) {
		ImageIcon icon = new ImageIcon(MainFramePanel.class.getResource(iconResource));
		icon = new ImageIcon(getScaledImage(icon.getImage(), width, height));
		MyButton button = new MyButton();
		button.setIcon(icon);
		button.setPressedBackgroundColor(Color.RED);
		button.setHoverBackgroundColor(Color.GREEN);
		button.setBorder(BorderFactory.createEmptyBorder());
		button.setSize(new Dimension(width, height));
		button.setLocation(locX, locY);
		button.setToolTipText(tooltip);
		return button;
	}
	
	public static Image getScaledImage(Image srcImg, int w, int h) {
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();
	    return resizedImg;
	}

}
