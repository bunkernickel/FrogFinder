import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class Display extends JPanel implements MouseInputListener, KeyListener {

	FrogManager manager = new FrogManager();
	MenuPanel menu;

	/**
	 * Construct a panel with specified width, height, and background color
	 * 
	 * @param width
	 * @param height
	 * @param bgColor
	 */
	public Display(int width, int height, Color bgColor) {
		setPreferredSize(new Dimension(width, height));
		setBackground(bgColor);

		this.addMouseListener(this);
		this.addMouseMotionListener(this);

		this.addKeyListener(this);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);
		
		
		Random rand = new Random();
		
		manager.addFrog(ImageManager.getInstance().images[ImageManager.Platfrog1], rand.nextInt(width), rand.nextInt(height), 100, 100, "Platfrog1");
		manager.addFrog(ImageManager.getInstance().images[ImageManager.BlackdiamondFrog1], rand.nextInt(width), rand.nextInt(height), 100, 100, "BlackdiamondFrog1");
		manager.addFrog(ImageManager.getInstance().images[ImageManager.DiamondCometFrog1], rand.nextInt(width), rand.nextInt(height), 100, 100, "DiamondCometFrog1");
		manager.addFrog(ImageManager.getInstance().images[ImageManager.DiamondFrog1], rand.nextInt(width), rand.nextInt(height), 100, 100, "DiamondFrog1");
		
		

	}

	protected void paintComponent(Graphics graphicHelper) {
		super.paintComponent(graphicHelper);
		Graphics2D g = (Graphics2D) graphicHelper;
		g.drawImage(ImageManager.getInstance().images[ImageManager.Background], 0, 0, getWidth(), getHeight(), this);

		for (Frog f : manager.frogs) {
			f.draw(g, this);
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
		int rand = (int) (Math.random() * manager.frogs.size());
		// manager.frogs.get(rand).move(e.getX(), e.getY());
		
		for (Frog f : manager.frogs) {
			if (f.contains(e.getPoint())) 
			{
				menu.frogs.add(f.getImage());
				
				menu.repaint();
				
				manager.frogs.remove(f);
			}
			
		
		}
		
		repaint();
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