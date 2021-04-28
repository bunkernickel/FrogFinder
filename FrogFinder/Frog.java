import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Frog {

	private BufferedImage image;
	int x, y, width, height;
	String name;

	public Frog(BufferedImage image, int x, int y, int width, int height, String name) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.image = image;
		this.name = name;
	}

	public void draw(Graphics2D g, JPanel panel) {
		g.drawImage(image, x, y, width, height, panel);
	}
	
	public boolean contains(Point p) {
		Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
		if (rect.contains(p)) {
			return true;
		} else {
			return false;
		}
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}

}
