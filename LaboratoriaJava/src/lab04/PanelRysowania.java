package lab04;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelRysowania extends JPanel {
	int lineWidth;
	int vertexNumber = 4;
	boolean isRegular;
	Color backgroundColor;
	Color lineColor;
	Dimension panelRysowaniaDimension = new Dimension(400, 400);


	public PanelRysowania() {
		super();
		setPreferredSize(panelRysowaniaDimension);
		this.setBackground(backgroundColor);
	}

	public boolean isRegular() {
		return isRegular;
	}

	public void setRegular(boolean isRegular) {
		this.isRegular = isRegular;
		//repaint();
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
		//repaint();
	}

	public int getVertexNumber() {
		return vertexNumber;
	}

	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
		//repaint();
	}

	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		//repaint();
	}

	public Color getLineColor() {
		return lineColor;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
		//repaint();
	}	
	
	@Override
	protected void paintComponent(Graphics g) {
		RegularPolyVertexCoordinates coords = new RegularPolyVertexCoordinates(vertexNumber,(panelRysowaniaDimension.width/2 - 20), panelRysowaniaDimension);
		
		
	    //g.setColor(backgroundColor);
	    g.drawPolygon(coords.getxPoints(), coords.getyPoints(), vertexNumber); // Fill the whole panel with the background color

//	    // Set line color
//	    g.setColor(Color.GREEN);
//
//	    // Draw a rectangle based on panel size
//	    int x = getWidth() / 4; // Position X of the rectangle
//	    int y = getHeight() / 4; // Position Y of the rectangle
//	    int width = getWidth() / 2; // Width of the rectangle
//	    int height = getHeight() / 2; // Height of the rectangle
//
//	    g.drawRect(x, y, width, height);

		
		
	}
	
}


