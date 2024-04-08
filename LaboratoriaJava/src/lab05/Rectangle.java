package lab05;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rectangle extends Shape {
	
	 private List<Integer> xList;
	 private List<Integer> yList;
	 private int startX;
	 private int startY;
	 private int currentX;
	 private int currentY;
	 
//	 private int rectangle

	 public Rectangle() {
		 xList = new ArrayList<Integer>();
	     yList = new ArrayList<Integer>();
	}
	 
	
	 
	public int getStartX() {
		return startX;
	}



	public void setStartX(int startX) {
		this.startX = startX;
	}



	public int getStartY() {
		return startY;
	}



	public void setStartY(int startY) {
		this.startY = startY;
	}



	public int getCurrentX() {
		return currentX;
	}



	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}



	public int getCurrentY() {
		return currentY;
	}



	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}



	public void addPoint(int x, int y) {
		xList.add(x);
		yList.add(y);
	}
	 
//	@Override
//	public void draw(Graphics2D g2d) {
//		for (int i = 0; i < xList.size() - 1; i++) {
//			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1));
//		}
//	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		int originX = Math.min(startX, currentX);
		int originY = Math.min(startY, currentY);
		int width = Math.abs(currentX - startX);
		int height = Math.abs(currentY - startY);
		
		g2d.drawRect(originX, originY, width, height);
		
//		g2d.drawRect(xList.get(0), yList.get(0), xList.get(xList.size()-1), yList.get(yList.size()-1));
		
//		g2d.drawRect(xList.get(), yList.get(0), xList.get(xList.size()), yList.get(yList.size()));
		
//		for (int i = 0; i < xList.size() - 1; i++) {
//			g2d.drawRect(xList.get(0), yList.get(0), xList.get(xList.size()), yList.get(yList.size()));
//		}

	}

}



