package lab05;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class LoadImage {
	private BufferedImage image;
	private Dimension dimension;
	
	public LoadImage(File filePath, Dimension dimension) {
		super();
        this.dimension = dimension;
		        
        try {
            image = ImageIO.read(filePath);
        } catch (IOException e) {
            System.err.println("Blad odczytu obrazka");
        }
	}
	
	public void draw(Graphics2D g2d) {
		if (image != null) {
			g2d.drawImage(image, 0, 0, (int)dimension.getWidth(), (int)dimension.getHeight(), null);
		}
	}
}
