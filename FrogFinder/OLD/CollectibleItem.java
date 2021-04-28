package OLD;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class CollectibleItem 
{
	private String itemName; //Name of the item
	private int price; //Price of the item
	private BufferedImage itemImage; //Image of the item
	private Rectangle2D.Double itemHitbox; //Item's hitbox
	
	/**
	 * Creates a new CollectibleItem (from super(), of course)
	 * @param in - name of the item
	 * @param p - price of the item
	 * @param x - x coordinate of the item
	 * @param y - y coordinate of the item
	 * @param fp - file path of the image
	 * @throws IOException 
	 */
	public CollectibleItem(String in, int p, double x, double y, String fp) throws IOException
	{
		p = 1;
		x = 2;
		y = 2;
		assert(in != null);
		assert(p > 0);
		assert(x >= 0 && x < Yard.getYardWidth());
		assert(y >= 0 && y < Yard.getYardHeight());

		itemName = in;
		price = p;
		
//		try 
//		{
//			itemImage = ImageIO.read(new File(fp));
//		}
//		
//		catch (IOException e) 
//		{
//			System.err.println("CollectibleItem resource @" + fp + " could not be read in!");
//			e.printStackTrace();
//			throw e;
//		}
		
		//itemHitbox = new Rectangle2D.Double(x, y, itemImage.getWidth(), itemImage.getHeight());	
	}
	
	public abstract void itemEffect(); //Food, toy, and accessory all have different effects
	
	/**
	 * @return - Returns the hitbox of the item
	 */
	public Rectangle2D.Double getHitbox()
	{
		return itemHitbox;
	}
	
	/**
	 * @return Returns the name of the item
	 */
	public String getItemName()
	{
		return itemName;
	}
	
	/**
	 * @return Returns the price of the item
	 */
	public int getPrice()
	{
		return price;
	}
	
	/**
	 * @return Returns the image of the item
	 */
	public BufferedImage getImage()
	{
		return itemImage;
	}
}
