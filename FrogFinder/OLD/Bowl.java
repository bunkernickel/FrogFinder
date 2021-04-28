package OLD;

public class Bowl extends Container
{
	private static Bowl instance; //Single instance of bowl object
	
	/**
	 * Creates a new bowl object
	 * @param x - The x location of the bowl
	 * @param y - The y location of the bowl
	 * @param fp - The file path of the bowl image
	 */
	private Bowl(double x, double y, String fp)
	{
		super(x, y, fp); //call constructor of CollectibleItem
	}
	
	/**
	 * @param x - x location of bowl
	 * @param y - y location of bowl
	 * @param fp - file path of the bowl
	 * @return Returns the single instance of the bowl
	 */
	public static Bowl getBowl(double x, double y, String fp)
	{
		if(instance == null) //If Bowl has not yet been created
		{
			assert(x >= 0 && x < Yard.getYardWidth());
			assert(y >= 0 && y < Yard.getYardHeight());
			assert(fp != null);
			instance = new Bowl(x, y, fp); //Create bowl
		}
		
		return instance; //return instance of bowl
	}
	
	/**
	 * @param f - The food to be placed in the bowl
	 */
	public void placeFoodInBowl(Food f)
	{
		assert(f != null);//Make sure that food is not null before inserting it into the bowl.
		setContainedItem(f); //Insert food into bowl.
	}
}
