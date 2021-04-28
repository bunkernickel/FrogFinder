package OLD;
import java.io.IOException;

public class Accessory extends CollectibleItem
{
	//TODO make accessory abstract and inherit from accessory for accessories of different effects...
	/**
	 * @param n - The name of the accessory
	 * @param p - The price of the accessory in the shop
	 * @param x - The X coordinate of the accessory on screen
	 * @param y - The y coordinate of the accessory on screen
	 * @param fp - The file path of the image of the accessory
	 * @throws IOException 
	 */
	public Accessory(String n, int p, double x, double y, String fp) throws IOException 
	{
		super(n, p, x, y, fp);
	}
	//TODO implement toy functionality by adding more methods as we expand the skeleton

	@Override
	public void itemEffect() 
	{
		// TODO Auto-generated method stub
		
	}
}
