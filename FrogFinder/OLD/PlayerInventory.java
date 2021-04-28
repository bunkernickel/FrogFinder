package OLD;

import java.util.ArrayList;

public class PlayerInventory 
{
	private static int currencyAmount; //Currency that the player owns (balance)
	private ArrayList<Toy> ownedToys; //Toys that the player owns
	private ArrayList<Food> ownedFood; //Food that the player owns
	private ArrayList<Accessory> ownedAccessories; //Accessories that the player owns
	
	/**
	 * The constructor below creates a new PlayerInventory() object and intiializes empty array lists of Toy, Food. and Accessory objects
	 */
	public PlayerInventory()
	{
		//Assert that the yard has been created before player inventory.
		assert(Yard.getYardWidth() > 0);
		assert(Yard.getYardHeight() > 0);
		
		currencyAmount = 1000; // Each player begins with 1000 currency
		//TODO - load currency from file
		
		ownedToys = new ArrayList<Toy>(); //Create player's toylist
		
		ownedFood = new ArrayList<Food>(); // Create player's owned food list
		
		ownedAccessories = new ArrayList<Accessory>(); //Create the player's owned accessory list
		
	}
	 
	/*
	 * The method below returns the currency owned by the player.
	 */
	public static int getCurrencyAmount()
	{
		assert(currencyAmount >= 0);
		return currencyAmount;
	}
	
	/**
	 * @param charge - The amount added or decremented to/from the player's inventory
	 * - < 0 = decrement
	 * > 0 = increment
	 */
	public void alterCurrencyAmount(int charge)
	{
		assert((currencyAmount + charge) >= 0);
		currencyAmount += charge;
	}
	
	//TODO - add more methods that will make the PlayerInventory class more useful
}
