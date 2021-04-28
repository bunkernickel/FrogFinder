package OLD;

import java.util.ArrayList;

public class Store {

		//Will hold all food objects able to be purchased...
		public ArrayList<Food> foodList;
		//Will hold all toy objects able to be purchased...
		public ArrayList<Toy> toyList;
		//Will hold all jewelry / accessory items able to be purchased...
		public ArrayList<Accessory> accessoryList;
		
		public Store()
		{
			foodList = new ArrayList<Food>();
			toyList = new ArrayList<Toy>();
			accessoryList = new ArrayList<Accessory>();
		}
		
		/**
		 * Buys food from the shop
		 * @param food - the specific food to be bought
		 * @param price - the price of the food
		 */
		public void buyFood(Food food, int price)
		{
			assert(food != null);
			assert(price <= PlayerInventory.getCurrencyAmount());
			assert(foodList.indexOf(food) != -1);
			
			//TODO find food and return it
			//TODO decrement player's balance by the price of the food
		}
		
		/**
		 * Buys a toy from the shop
		 * @param toy - the specific toy to be bought
		 * @param price - the price of the toy
		 */
		public void buyToy(Toy toy, int price)
		{
			assert(toy != null);
			assert(price < PlayerInventory.getCurrencyAmount());
			assert(toyList.indexOf(toy) != -1);
			
			//TODO - iterate through the toy list and find the toy return it
			//TODO - decrement the player's balance by the amount of the toy
		}
		
		/**
		 * Buys a toy from the shop
		 * @param toy - the specific toy to be bought
		 * @param price - the price of the toy
		 */
		public void buyToy(Accessory a, int price)
		{
			assert(a != null);
			assert(price < PlayerInventory.getCurrencyAmount());
			assert(toyList.indexOf(a) != -1);
			
			//TODO - iterate through the toy list and find the toy return it
			//TODO - decrement the player's balance by the amount of the toy
		}
		
		
		/**
		 * @param t - toy to be added to the toy list
		 * The method below adds a toy to the list of toys able to be purchased
		 */
		public void addToy(Toy t)
		{
			assert(t != null);
			assert(t.getPrice() > 0 && t.getPrice() < Integer.MAX_VALUE);
			//TODO - add toy to toylist
		}
		
		/**
		 * @param f - food to be added to the food list
		 * The method below addsa  food to the list of food able to be purchased
		 */
		public void addFood(Food f)
		{
			assert(f != null);
			assert(f.getPrice() > 0 && f.getPrice() < Integer.MAX_VALUE);
			//TODO - add food to food list
		}
		
		public void addAccessory(Accessory a)
		{
			assert(a != null);
			assert(a.getPrice() > 0 && a.getPrice() < Integer.MAX_VALUE);
			//TODO - add the accessory to the food list
		}
		
		public ArrayList<Food> getFoodList()
		{
			assert(foodList != null);
			return foodList;
		}
}
