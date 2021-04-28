import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageManager {

	private static ImageManager instance;
	public static final int BlackdiamondFrog1 = 0;
	public static final int BlackdiamondFrog2 = 1;
	public static final int BlackdiamondFrog3 = 2;
	public static final int DiamondCometFrog1 = 3;
	public static final int DiamondCometFrog2 = 4;
	public static final int DiamondCometFrog3 = 5;
	public static final int DiamondFrog1 = 6;
	public static final int DiamondFrog2 = 7;
	public static final int DiamondFrog3 = 8;
	public static final int Platfrog1 = 9;
	public static final int Platfrog2 = 10;
	public static final int Platfrog3 = 11;
	public static final int Background = 12;
	
	BufferedImage[] images;

	public ImageManager() {
		try {
			images = new BufferedImage[] 
					{ 
					ImageIO.read(getClass().getResource("BlackdiamondFrog1.png")),
					ImageIO.read(getClass().getResource("BlackdiamondFrog2.png")),
					ImageIO.read(getClass().getResource("BlackdiamondFrog3.png")),
					ImageIO.read(getClass().getResource("DiamondCometFrog1.png")),
					ImageIO.read(getClass().getResource("DiamondCometFrog2.png")),
					ImageIO.read(getClass().getResource("DiamondCometFrog3.png")),
					ImageIO.read(getClass().getResource("DiamondFrog1.png")),
					ImageIO.read(getClass().getResource("DiamondFrog2.png")),
					ImageIO.read(getClass().getResource("DiamondFrog3.png")),
					ImageIO.read(getClass().getResource("Platfrog1.png")),
					ImageIO.read(getClass().getResource("Platfrog2.png")),
					ImageIO.read(getClass().getResource("Platfrog3.png")),
					ImageIO.read(getClass().getResource("Background.png"))
					};
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static ImageManager getInstance() {
		if (instance == null) {
			instance = new ImageManager();
		}
		return instance;
	}

}
