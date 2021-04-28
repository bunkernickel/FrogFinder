import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class FrogManager {

	ArrayList<Frog> frogs = new ArrayList<Frog>();

	public void addFrog(BufferedImage icon, int x, int y, int width, int height, String name) {

		Frog f = new Frog(icon, x, y, width, height, name);
		frogs.add(f);
		
	}

}
