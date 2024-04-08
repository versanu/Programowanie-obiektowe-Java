package lab05;

import java.awt.Color;
import java.awt.Graphics2D;

abstract public class Shape {
	protected Color lineColor;
	protected int lineWidth;
	
	public Shape(Color lineColor, int lineWidth) {
		this.lineColor = lineColor;
		this.lineWidth = lineWidth;
	}
	
	abstract public void draw(Graphics2D g2d);
}
