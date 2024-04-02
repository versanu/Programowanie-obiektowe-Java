package lab04;

import java.awt.Dimension;
import java.util.Random;

public class RandomPolyVertexCoordinates {
	int sides;
	Dimension panelDimensions;
	int margin;
	int[] xPoints;
	int[] yPoints;

	public RandomPolyVertexCoordinates(int sides, Dimension panelDimensions, int margin) {
		super();
		this.sides = sides;
		this.panelDimensions = panelDimensions;
		this.margin = margin;
		
		xPoints = new int[sides];
		yPoints = new int [sides];
		
		Random rand = new Random();
		for (int i = 0; i < sides; i++) {
			xPoints[i] = (int) (margin +rand.nextInt(panelDimensions.width - 2*margin));
			yPoints[i] = (int) (margin + rand.nextInt(panelDimensions.height - 2*margin));
		}
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}
}
