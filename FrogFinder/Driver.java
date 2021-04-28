import java.awt.Color;
import javax.swing.JFrame;

public class Driver {
	public static void main(String[] args) {
		Display panel = new Display(1000, 1000, Color.white);
		JFrame frame = new JFrame("Frog Finder");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		
		JFrame menuFrame = new JFrame("Menu");
		MenuPanel menu = new MenuPanel(1000, 1000, Color.white);
		menu.mainDisplay = panel;
		panel.menu = menu;
		menuFrame.setLocation(800, 0);
		menuFrame.add(menu);
		menuFrame.pack();
		menuFrame.setVisible(true);
	}
}
