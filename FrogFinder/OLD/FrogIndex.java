package OLD;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashSet;

public class FrogIndex 
{
	private HashSet<Frog> playerIndex; //The player's found frogs.
	private static HashSet<Frog> allCreatedFrogs = new HashSet<Frog>(); //All frogs to ever exist.
	private BufferedImage pages[]; //The pages of the player's FrogIndex.
	private int currentPage; //Current page being viewed in the index.
	
	public FrogIndex()
	{
		//Dr. Gurary, we are not sure where to put assertions in this constructor. It seems that none are needed here.
		playerIndex = new HashSet<Frog>();
		//Each FrogIndex will feature seven pages of frogs.
		pages = new BufferedImage[7];
		//Current page being viewed will be set to zero initially. 
		currentPage = 0;
	}
	
	public void show(Graphics2D g)
	{
		assert(g != null);
		
		assert(currentPage >= 0 && currentPage < pages.length);
		//Frog index will be drawn in the same location each time...
		g.drawImage(pages[currentPage], 100, 100, null);
		
		//TODO - Draw 25 frogs on each page.
		//TODO - Implement the gray/colored for frogs that the user has found or not found.
		// EX: Frogs at indices 0 - 24 will be drawn on the first page. 25 - 49 on the second page, etc. 
	}
	
	/**
	 * @return Returns the hashset of all frogs currently able to be discovered in the game.
	 */
	public static HashSet<Frog> getAllCreatedFrogs()
	{
		assert(allCreatedFrogs != null);
		return allCreatedFrogs;
	}
	
	/**
	 * @return Returns the player's frog index.
	 */
	public HashSet<Frog> getPlayerIndex()
	{
		assert(playerIndex != null);
		return playerIndex;
	}
	
	/**
	 * @param incrementPage - Whether the page number will be incremented or decremented.
	 * This will make more sense when the UI is set up. This method allows the user to change the page currently being viewed in the FrogIndex.
	 */
	public void turnPage(boolean incrementPage)
	{
		try
		{
			if(incrementPage)
				currentPage++;
			else
				currentPage--;
		}
		catch(AssertionError a)
		{
			;
		}
		//TODO - Add logic that will allow us to remove this assertion. (I.E. page will not turn if an out of bounds exception will be thrown.)
	}
	
	/**
	 * @param f - The frog to be added to the player's frog index.
	 */
	public void addFrog(Frog f)
	{
		assert(f != null);
		
		if(!playerIndex.contains(f))
			playerIndex.add(f);
		
		System.err.println("User has already discovered this frog.");
	}
	
	/**
	 * @param f - The frog to be added to the all known frogs HashSet.
	 * 
	 */
	public static void addToAllKnownFrogs(Frog f)
	{
		assert(f != null); // The frog must not be null to add it to the all known frog index.
		
		if(!allCreatedFrogs.contains(f)) // If the frog is not in the all known frogs hashset. 
			allCreatedFrogs.add(f);
		
		System.err.println("This frog already exists!");
	}
	
	/**
	 * @return Returns the current page that the user is viewing in their frog index
	 */
	public int getPage()
	{
		return currentPage;
	}
}
