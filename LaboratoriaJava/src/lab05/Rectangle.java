package lab05;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rectangle extends Shape {
	
	 private List<Integer> xList;
	 private List<Integer> yList;

	 public Rectangle() {
		 xList = new ArrayList<Integer>();
	     yList = new ArrayList<Integer>();
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
		
		g2d.drawRect(xList.get(0), yList.get(0), xList.get(xList.size()-1), yList.get(yList.size()-1));
		
//		g2d.drawRect(xList.get(), yList.get(0), xList.get(xList.size()), yList.get(yList.size()));
		
//		for (int i = 0; i < xList.size() - 1; i++) {
//			g2d.drawRect(xList.get(0), yList.get(0), xList.get(xList.size()), yList.get(yList.size()));
//		}

	}

}



