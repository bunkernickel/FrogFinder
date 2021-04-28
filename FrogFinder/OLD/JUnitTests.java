package OLD;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Toolkit;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class JUnitTests {

	@Test
	void test() throws IOException 
	{
		//Change the null values and primitive data types to test various different objects!
		//Yard testYard = new Yard(Toolkit.getDefaultToolkit().getScreenSize());
		
		//TESTS FOR BOWL
		Bowl b = Bowl.getBowl(0, 0, "bowl.png");
		Bowl fff = Bowl.getBowl(1, 1, "bowl.png");
		
		assertTrue(b == fff); //compare references to ensure that they are indeed the same bowl. (singleton)
		
		//TESTS FOR FOOD
		Food f = new Food("Flies", 500, 0, 0, "food.png");
		assertTrue(f.getItemName().equals("Flies"));
		assertFalse(f.getItemName().equals("Orange"));
		
		b.placeFoodInBowl(f);
		assertTrue(b.getContainedItem().equals(f));
		
		//TESTS FOR FROG
		Frog ff = new Frog(0, 0, Type.DIAMONDI, "Test Frog", "testfrog.png");
		
		ff.moveFrog(15.0, 15.0);
		//System.out.print(ff.getFrogX());
		assertTrue(ff.getFrogX() == 15.0);
		assertTrue(ff.getFrogY() == 15.0);
		assertTrue(ff.getSpawnRate() == 0.5);
		ff.moveFrog(Yard.getYardWidth(), Yard.getYardHeight()); //should fail
		
		//TESTS FOR FROGINDEX
		FrogIndex fi = new FrogIndex();
		assertTrue(fi.getPage() == 0);
		fi.turnPage(true);
		assertTrue(fi.getPage() == 1);
		fi.turnPage(false);
		assertTrue(fi.getPage() == 0);
		fi.addFrog(ff);
		
		Accessory a = new Accessory("Diamond Jordan Shoes", 0, 0, 0, "djs.png");
		
		ff.addAccessory(a);
		assertTrue(ff.getWearingThese()[0].equals(a));
		
		
		//TESTS PLAYERINVENTORY
		PlayerInventory pi = new PlayerInventory();
		
		pi.alterCurrencyAmount(-500);
		assertTrue(PlayerInventory.getCurrencyAmount() ==500);
		assertFalse(PlayerInventory.getCurrencyAmount() < 0);
		
		//TESTS FOR STAND
		Stand s = Stand.getStand(0, 0, "stand.png");
		Stand testStand = Stand.getStand(0, 0, "stand.png");
		
		assertTrue(s == testStand);
		
		
		//TESTS FOR STORE
		Store ss = new Store();
		
		//Testing adding collectible items to store.
		ss.addFood(f);
		assertTrue(ss.getFoodList().contains(f));
		
		ss.buyFood(f, 500); //deduct 500 from player balance
		assertTrue(PlayerInventory.getCurrencyAmount() == 500); //at this point, player balance should be 500, as the player starts with 1000
		assertFalse(ss.getFoodList().contains(f)); //food is removed from the store after being purchased
		
		
		//TODO - add JUnit tests for Toy and Accessory when additional functionality is added. For now it is fine with just Food as they are all technically the same and share a similar purpose
		//All three provide an effect are are simply just an image (Also, consider creating a new inheritance structure for Accessory)
	}

}
