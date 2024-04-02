package lab04;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelRysowania extends JPanel {
	int lineWidth = 2;
	int vertexNumber = 3;
	boolean isRegular = true;
	Color backgroundColor = Color.WHITE;
	Color lineColor = Color.BLACK;
	Dimension panelRysowaniaDimension = new Dimension(400, 400);
	int margin = 20;

	public PanelRysowania() {
		super();
		setPreferredSize(panelRysowaniaDimension);
	}

	public void setRegular(boolean isRegular) {
		this.isRegular = isRegular;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public void setVertexNumber(int vertexNumber) {
		this.vertexNumber = vertexNumber;
	}

	public void setLineColor(Color lineColor) {
		this.lineColor = lineColor;
	}
	
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(backgroundColor);
	    g.fillRect(0, 0, panelRysowaniaDimension.width, panelRysowaniaDimension.height);
	    
	    Graphics2D g2d = (Graphics2D) g;
	    g2d.setStroke(new BasicStroke(lineWidth));
	    
	    if(isRegular) {
	    	RegularPolyVertexCoordinates coords = new RegularPolyVertexCoordinates(vertexNumber,(panelRysowaniaDimension.width/2 - margin), panelRysowaniaDimension);
	    	g2d.setColor(lineColor);
		    g2d.drawPolygon(coords.getxPoints(), coords.getyPoints(), vertexNumber);
	    } else {
	    	RandomPolyVertexCoordinates coords = new RandomPolyVertexCoordinates(vertexNumber, panelRysowaniaDimension, margin);
	    	g2d.setColor(lineColor);
	    	g2d.drawPolygon(coords.getxPoints(), coords.getyPoints(), vertexNumber);
	    }
	}
}


