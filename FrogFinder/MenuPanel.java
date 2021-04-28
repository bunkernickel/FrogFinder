import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MenuPanel extends JPanel implements MouseInputListener, KeyListener {

	Display mainDisplay;
	
	List<BufferedImage> frogs = new ArrayList<BufferedImage>();

	/**
	 * Construct a panel with specified width, height, and background color
	 * 
	 * @param width
	 * @param height
	 * @param bgColor
	 */
	public MenuPanel(int width, int height, Color bgColor) {
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;
		
		if (frogs != null) {
			for(int i = 0; i < frogs.size(); i++) {
				g.setFont(new Font("Times", Font.BOLD, 20));
				g.drawString("Frog " + (i + 1), 120 + (200 * i), 80);
				g.drawImage(frogs.get(i), 100 + (200 * i), 100, 150, 150, this);
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent k) {
		System.out.println(k.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent k) {
	}

	@Override
	public void keyTyped(KeyEvent k) {
	}

}