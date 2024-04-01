package lab04;

import java.awt.Dimension;



public class RegularPolyVertexCoordinates {
	int sides;
	int circumscribingR;
	Dimension panelDimensions;
	int[] xPoints;
	int[] yPoints;
	
	public RegularPolyVertexCoordinates() {
		System.out.println("Polygon Vertex Coordinates default constructor initiated");
	}

	public RegularPolyVertexCoordinates(int sides, int circumscribingR, Dimension panelDimensions) {
		super();
		this.sides = sides;
		this.circumscribingR = circumscribingR;
		this.panelDimensions = panelDimensions;
		
		xPoints = new int[sides];
		yPoints = new int [sides];
		
		for (int i = 0; i < sides; i++) {
			xPoints[i] = (int) ((circumscribingR * Math.cos((2 * Math.PI * i)/sides)) + panelDimensions.width/2);
			yPoints[i] = (int) ((circumscribingR * Math.sin((2 * Math.PI * i)/sides)) + panelDimensions.height/2);
			//System.out.println("x: " + xPoints[i] + "y: " + yPoints[i]);
		}
	}

	public int[] getxPoints() {
		return xPoints;
	}

	public int[] getyPoints() {
		return yPoints;
	}

	
	
	
}
