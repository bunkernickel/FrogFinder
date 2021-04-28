package OLD;
import java.io.IOException;

public class Food extends CollectibleItem
{
	//TODO This class should be abstract. Food effects 
	
	/**
	 * @param in - The name of the food.
	 * @param p - The price of the food in the store.
	 * @param x - The X coordinate of the food on screen.
	 * @param y - The Y coordinate of the food on screen.
	 * @param fp - The file path of the image of the food.
	 * @throws IOException 
	 */
	
	public Food(String in, int p, double x, double y, String fp) throws IOException 
	{
		super(in, p, x, y, fp);
	}
	
	//TODO implement food functionality by adding more methods as we expand the skeleton...
	public void itemEffect() 
	{
		
	}
	
	
}
