package OLD;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class FrogFinder extends JFrame 
{
	/**
	 * TO BE DONE STILL:
	 * UI elements still need to be added and were not considered in the original code skeleton... (I.E. buttons, text entry, etc.)
	 * Sprite & SpriteSheet classes (how can we make animation appear more fluid than static images moving across the screen)
	 * Collision detection (perhaps an abstract class)
	 * Need to add more features/functionality Toy, Accessory, and Toy
	 */
	
	//Main - avoid sTaTiCiTiS
	public static void main(String[] args) 
	{
		new FrogFinder().runCode();
	}

	//Run code method will create a new Yard object.
	public void runCode()
	{
		//Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize(); //Grab dimension of the user's screen
		Dimension screenDimension = new Dimension(600,450);
		
		this.setVisible(true); //Make the JFrame visible
		this.setSize(screenDimension); //Set the size of the JFrame
		this.setTitle("Frog Finder");
		this.add(new Yard(screenDimension)); //Add a Yard panel to the frame
		
	}
}