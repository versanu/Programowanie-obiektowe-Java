package lab05;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rectangle extends Shape {
	 private int startX;
	 private int startY;
	 private int currentX;
	 private int currentY;

	 public Rectangle(Color lineColor, int lineWidth) {
		 super(lineColor, lineWidth);
	}
	 
	public void setStartPoint(int startX, int startY) {
		this.startX = startX;
		this.startY = startY;
	}

	public void setEndPoint(int currentX, int currentY) {
		this.currentX = currentX;
		this.currentY = currentY;
	}

	
	@Override
	public void draw(Graphics2D g2d) {
		
		int originX = Math.min(startX, currentX);
		int originY = Math.min(startY, currentY);
		int width = Math.abs(currentX - startX);
		int height = Math.abs(currentY - startY);
		
		g2d.setColor(lineColor);
		g2d.setStroke(new BasicStroke(lineWidth));
		g2d.drawRect(originX, originY, width, height);
	}
}



