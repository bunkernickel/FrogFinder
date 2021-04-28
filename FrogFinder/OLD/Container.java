package OLD;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Container //Both stand and bowl will inherit this container class as they both simply hold objects and provide no other functionality.
{
	private CollectibleItem containedItem; //The item contained in the bowl/stand
	private BufferedImage containerImage; //The image of the bowl/stand
	private Rectangle2D.Double hitbox; //Hitbox of the container
	
	/**
	 * Creates a new container object. (with super(), of course)
	 * @param x - X coordinate of the container on the screen
	 * @param y - Y coordinate of the conbtainer on the screen
	 * @param fp - The file path of the image
	 */
	public Container(double x, double y, String fp)
	{
		assert(fp != null); //Ensure that file path is not null
		assert(x >= 0 && x < Yard.getYardWidth()); //Ensure that the location of the Container is within the bounds of the Yard
		assert(y >= 0 && y < Yard.getYardHeight()); // The location of the container must be within the bounds of the yard
//		try 
//		{
//			containerImage = ImageIO.read(new File(fp)); //Read in file
//			hitbox = new Rectangle2D.Double(x, y, containerImage.getWidth(), containerImage.getHeight()); //Create hitbox
//		} 
//		
//		catch (IOException e) 
//		{
//			System.err.println("Container resource failed to be loaded! Check file path and restart!");
//			e.printStackTrace();
	}
//		

	
	/**
	 * The method 'show' will draw the contained object to the user's screen.
	 * @param g - Graphics object of Yard
	 */
	public void show(Graphics g)
	{
		assert(g != null); //Ensure that the graphic object is not null
		assert(hitbox.getX() >= 0 && hitbox.getX() < Yard.getYardWidth()); //Ensure that the container is within the width bounds of the yard
		assert(hitbox.getY() >= 0 && hitbox.getY() < Yard.getYardHeight()); //Ensure that the container is within the height bounds of the yard
		g.drawImage(containerImage, (int) hitbox.getX(), (int) hitbox.getY(), null); //draw image to the screen
		//TODO: Draw the image of the contained item on top of the image of the bowl/stand
	}
	
	/**
	 * The method below will remove the object from the container.
	 */
	public void removeItem()
	{
		assert(containedItem != null); //Ensures that the container is not already empty.
		containedItem = null;
	}
	
	/**
	 * @return The method below returns the CollectibleItem object 
	 */
	public CollectibleItem getContainedItem()
	{
		assert(containedItem != null); //Ensures that the container is not empty.
		return containedItem;
	}
	
	//Change the item held by the container.
	protected void setContainedItem(CollectibleItem c)
	{
		assert(c != null);
		assert(c.getClass().getName().equals("Food" )|| c.getClass().getName().equals("Toy"));
		containedItem = c;
	}
	
	/**
	 * @return - Returns the x value of the container.
	 */
	public double getX()
	{
		return hitbox.getX();
	}
	
	/**
	 * @return Returns the y-value of the container.
	 */
	public double getY()
	{
		return hitbox.getY();
	}
	
	/**
	 * Returns whether or not the container is empty.
	 * @return True if the container is empty. False if it is not.
	 */
	public boolean isEmpty()
	{
		return containedItem == null;
	}
	
	/**
	 * @return Returns an image of the container
	 */
	public BufferedImage getImage()
	{
		assert(containerImage != null);
		return containerImage;
	}
}
