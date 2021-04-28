package OLD;
import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class Yard extends JPanel implements MouseListener, KeyListener
{
    private static double yardWidth; //The width of the yard.
    private static double yardHeight; //The height of the yard.
    private ArrayList<Frog> frogsInYard; //The frogs that are currently in the yard.
    private ArrayList<CollectibleItem> activeItems;
    private Stand toyStand; //The toy stand placed in the yard.
    private Bowl foodBowl; //The food bowl placed in the yard.
    private Store availableToPurchase; //Store that the player can purchase items from
    private PlayerInventory itemsOfThePlayer;

    /**
     * Creates a new Yard object.
     * @param d - The dimension of the yard passed in from the FrogFinder class.
     */
    public Yard(Dimension d)
    {
    	assert(d.getWidth() > 0); //Width must be greater than zero.
    	assert(d.getHeight() > 0); //Height must be greater than zero.
    	
    	yardWidth = d.getWidth(); //Assign yardWidth
    	yardHeight = d.getHeight(); //Assign yardHeight
    	
        frogsInYard = new ArrayList<Frog>();
        
        assert(frogsInYard.size() == 0); //There should be zero frogs in the yard initially.
        
        toyStand = Stand.getStand(yardWidth*(1.0/3), yardHeight/2.0, "standImage.png"); //Create a new stand with a fixed location in the middle of the yard to the left.
        foodBowl = Bowl.getBowl(yardWidth*(2.0/3), yardHeight/2.0, "bowlImage.png"); //Create a new bowl with a fixed location in the center but to the left.
        
        availableToPurchase = new Store();//Create new store that will hold items for player to purchase.
        itemsOfThePlayer = new PlayerInventory(); //Creates an inventory for the player.
        
        //TODO add a method that will load the player's inventory from a file on the user's inventory so that progress is not lost upon exiting the application
       
    	int width = (int) yardWidth;
        int height = (int) yardHeight;
        
        /*
         * Background
         */	
    	JLabel background = new JLabel("");
    	background.setIcon(new ImageIcon("/Users/jaredflitt/Desktop/TEST/background.png"));
        background.setBounds(0, 0, width, height);
        this.add(background);
        
        this.addMouseListener(this);
       
    }
    
    protected void paintComponent(Graphics g)
    {
    	Graphics2D game2D = (Graphics2D)g;
    	
    	assert(g != null); //Graphics should not be null
    	assert(toyStand != null); //Assert that the toy stand is not null when drawing
    	assert(toyStand.getImage() != null); //Assert that the image of the toy stand is not null
    	//toyStand.show(game2D); //Show the toy stand
    	assert(foodBowl != null); //Food bowl should not be null 
    	assert(foodBowl.getImage() != null); //make sure image of the container is not null before showing
    	//foodBowl.show(game2D); //Show the food bowl
    	
    	for(Frog f: frogsInYard) //Iterate through each frog in the yard
    	{
    		assert(f != null);//Frog object should not be null
    		assert(f.getImage() != null); //Image of the frog should not be null
    		//f.show(game2D); //Show the frog on the screen
    	}
  
    }
    
    public void spawnFrog()
    {
    	//TODO - This method will spawn a frog every minute if both a toy is on the stand and food is in the bowl.
    	//Be sure to use the rateMap when writing this method as well as Math.random() to determine an appropriate rarity.
    	while(toyStand.getContainedItem() != null && foodBowl.getContainedItem() != null)
    	{
    		
    	}
    }
    
    public void activateEffects()
    {
    	for(CollectibleItem c: activeItems)
    	{
    		c.itemEffect();
    	}
    }

    //TODO - add method to remove frogs from the screen if there is no food or toy
    
    /**
     * Implement this later to handle a key-pressed event.
     */
	@Override
	public void keyPressed(KeyEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Implement this later to handle the event when a key is released.
	 */
	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Implement this later to handle when a key is typed.
	 */
	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Implement this later to handle when the mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) 
	{
		PointerInfo a = MouseInfo.getPointerInfo();
		Point point = new Point(a.getLocation());
		SwingUtilities.convertPointFromScreen(point, e.getComponent());
		String x = String.format("%03d", e.getX());
		String y = String.format("%03d", e.getY());
		System.out.println(x + ", " + y);
		
	}

	/**
	 * Implement this later to handle when a mouse enters the panel.
	 */
	@Override
	public void mouseEntered(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Implement this later to handle when the mouse exists the panel.
	 */
	@Override
	public void mouseExited(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Implement this later to handle when the mouse is pressed.
	 */
	@Override
	public void mousePressed(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
	}

	/**
	 * Implement this later to handle when the mouse is released.
	 */
	@Override
	public void mouseReleased(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
	}
	
	/**
	 * @return Returns the width of the yard.
	 */
	public static double getYardWidth()
	{
		yardWidth = 1;
		assert(yardWidth > 0);
		
		return 10;
	}
	
	/**
	 * @return Returns the height of the yard.
	 */
	public static double getYardHeight()
	{
		yardHeight = 1;
		assert(yardHeight > 0);
		
		return 10;
	}
		

}
