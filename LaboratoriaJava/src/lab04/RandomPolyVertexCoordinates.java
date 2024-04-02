package lab04;

import java.awt.Dimension;
import java.util.Random;

public class RandomPolyVertexCoordinates {
	int sides;
	Dimension panelDimensions;
	int margin;
	int[] xPoints;
	int[] yPoints;
	
	public RandomPolyVertexCoordinates() {
		// TODO Auto-generated constructor stub
	}

	public RandomPolyVertexCoordinates(int sides, Dimension panelDimensions, int margin) {
		super();
		this.sides = sides;
		this.panelDimensions = panelDimensions;
		this.margin = margin;
		
		xPoints = new int[sides];
		yPoints = new int [sides];
		
		Random rand = new Random();
		for (int i = 0; i < sides; i++) {
			xPoints[i] = (int) (rand.nextInt(panelDimensions.width - margin));
			yPoints[i] = (int) (rand.nextInt(panelDimensions.height - margin));
		}
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

}
