package OLD;
public class Stand extends Container
{
	private static Stand instance; //Single instance of the stand.
	//No additional assertions are required in this class as they are present in the Container class..
	
	/**
	 * @param x - X value of the stand on the screen
	 * @param y - Y value of the stand on the screen
	 * @param fp - file path of the image of the stand
	 */
	private Stand(double x, double y, String fp)
	{
		super(x, y, fp); //Call super constructor 
	}
	
	public static Stand getStand(double x, double y, String fp)
	{
		if(instance == null) //If a stand has not already been created
			instance = new Stand(x, y, fp); //Create a new stand
		
		return instance; //Return the instance of stand
	}
	
	/*
	 * Takes in a toy and places it in on the stand.
	 * t - The toy to be placed on the stand. 
	 * Assertions not present here as they are in the container class. 
	 */
	public void placeToyOnStand(Toy t)
	{
		setContainedItem(t);
	}
}