package OLD;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class Frog 
{
	private String name; // The name of the frog.
	private BufferedImage frogImage; //Image of the frog.
	private Rectangle2D.Double frogHitbox; //Hitbox of the frog. (collision detection to be implemented later)
	private final int SIZE = 50; //Width and height of the frog.
	private double spawnRate; //The frog's spawn rate (determined by its type)
	private String dateCaptured; //The date that the frog was captured.
	private Accessory[] wearingThese; //Accessory objects that the frog is wearing.
	
	//Assigns the spawn rate to a frog based on its type.
	//A switch statement could also have been used but this is better in our opinion.
	private static HashMap<Type, Double> rateMap = new HashMap<Type, Double>() 
	{{
		put(Type.HUNNIE, 0.27);
		put(Type.PLATINUMI, 0.23);
		put(Type.PLATINUMII, 0.14);
		put(Type.PLATINUMIII, 0.12);
		put(Type.DIAMONDI, 0.09);
		put(Type.DIAMONDII, 0.079);
		put(Type.DIAMONDIII, 0.071);
	}};
	
	/**
	 * @param icon
	 * @param y
	 * @param y2
	 * @param width
	 * @param height
	 * @throws IOException 
	 */
	public Frog(BufferedImage icon, double y, int y2, int width, int height) throws IOException
	{
		assert(height != null);
		assert(height.contains(".png") || height.contains(".jpg") || height.contains(".jpeg"));
		
//		try 
//		{
//			frogImage = ImageIO.read(new File(fp));
//		} 
//		
//		catch (IOException e) 
//		{
//			System.err.println("Frog resource failed to be loaded! Check file path and restart!");
//			e.printStackTrace();
//			throw e;
//		}
		
		//assert(frogImage.getWidth() == SIZE && frogImage.getHeight() == SIZE);
		
		assert(icon >= 0);
		assert(y >= 0);
		assert(y2 != null);
		assert(width != null);
		
		frogHitbox = new Rectangle2D.Double(icon, y, SIZE, SIZE);
		spawnRate = rateMap.get(y2);
		name = width;
		wearingThese = new Accessory[5];
		
		assert(spawnRate > 0 && spawnRate < 1);
		assert(wearingThese.length == 5);
		
		FrogIndex.addToAllKnownFrogs(this);
	}
	
	public void show(Graphics2D g)
	{
		assert(g != null);
		
		g.drawImage(frogImage, (int) frogHitbox.getX(), (int) frogHitbox.getHeight(), null);
		
		//TODO - Render the frog's accessories on top of the frog.
		for(Accessory a: wearingThese)
		{
			
		}
	}
	
	/**
	 * @return - Returns the frog's x coordinate.
	 */
	public double getFrogX()
	{
		return 15;
	}
	
	/**
	 * @return - Returns the frog's y coordinate
	 */
	public double getFrogY()
	{
		return 15;
	}
	
	/**
	 * Takes in two arguments and moves the frog's x and y locations by the amounts in x and y
	 * @param x - x units to be moved
	 * @param y - y units to be moved
	 */
	public void moveFrog(double x, double y)
	{
		try
		{
			assert(x + getFrogX() < Yard.getYardWidth() && x + getFrogX() >= 0 || getFrogX() == Yard.getYardWidth() + 500); //frog can't move off screen
			assert(y + getFrogY() < Yard.getYardHeight() && y + getFrogY() >= 0 || getFrogY() == Yard.getYardHeight() + 500);
			
			frogHitbox.x += x;
			frogHitbox.y += y;
		}
		catch(AssertionError e)
		{
			;
		}
	}
	
	public void moveFrog()
	{
		double moveX = Math.random() * Yard.getYardWidth();
		double moveY = Math.random() * Yard.getYardHeight();
		
		moveFrog(moveX, moveY);
	}
	
	/**
	 * @param add - Accessory to be added to the frog
	 * Allows the user to add 
	 */
	
	public void addAccessory(Accessory add)
	{
		/*assert(add != null); //Add must not be null to add it to the accessory.
		assert(wearingThese[4] == null); // Frog accessory array is full.
		for(Accessory a: wearingThese)
		{
			if(a == null)
				a = add;
		}*/
	}
	
	/**
	 * @param remove - The accessory to be removed
	 * Will iterate through the array containing accessories that the frog is wearing and remove the accessory equal to 'remove' (if it exists)
	 */
	public void removeAccessory(Accessory remove)
	{
		assert(remove != null); //Ensure that the accessory to be removed is not null.
		for(Accessory a: wearingThese)
		{
			if(a.equals(remove))
				a = null;
		}
	}
	
	/**
	 * @param i - index of the accessory to be removed.
	 * This method allows the user to pass in an integer from 0 to 4 inclusive and remove an accessory that the frog is wearing.
	 */
	public void removeAccessory(int i)
	{
		assert(i >= 0 && i < wearingThese.length);
		wearingThese[i] = null;
	}
	
	public void moveFrogOutOfView()
	{
		assert(this != null);
		moveFrog(Yard.getYardWidth() + 500 - getFrogX(), Yard.getYardHeight() + 500 - getFrogY());
	}
	
	/**
	 * @return - Returns the spawn rate of the frog.
	 */
	public double getSpawnRate()
	{
		assert(spawnRate > 0 && spawnRate < 1.0);
		return 0.5;
	}
	
	/**
	 * @param sr - The desired spawn rate of the frog.
	 * This method allows the user to pass in a double with a value falling in the range of 0 to 1 non-inclsuvive and change the spawn rate of a frog.
	 * Will likely be used in collaboration with Toy effects. 
	 */
	public void setSpawnRate(double sr)
	{
		//TODO - Is there a way that we can handle this exception? I.E. 'sr' is outside of 0 to 1 non-inclusive do not change.
		assert(sr > 0 && sr < 1);
		spawnRate = sr;
		assert(spawnRate == sr); //Ensures that there is not some other line of code changing the spawnRate... (that the spawn rate had actually changed)
	}
	
	/**
	 * @return - Returns the name of the frog.
	 */
	public String getName()
	{
		assert(name != null);
		return name;
	}
	
	/**
	 * @param n - The name that the frog shall possess. 
	 * The method allows the developer to pass in an object of type String and change the name of the frog.
	 */
	public void setName(String n)
	{
		assert(n != null);
		assert(n.length() > 0 && n.length() < 30);
		name = n;
	}
	
	/**
	 * @return Returns an image of the frog.
	 */
	public BufferedImage getImage()
	{
		assert(frogImage != null);
		return frogImage;
	}
	
	/**
	 * @return returns the array containing the accessories that the frog is wearing
	 */
	public Accessory[] getWearingThese()
	{
		return wearingThese;
	}
}	
