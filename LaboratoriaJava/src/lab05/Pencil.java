package lab05;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pencil extends Shape {
	
	 private List<Integer> xList;
	 private List<Integer> yList;

	 public Pencil() {
		 xList = new ArrayList<Integer>();
	     yList = new ArrayList<Integer>();
	}
	 
	public void addPoint(int x, int y) {
		xList.add(x);
		yList.add(y);
	}
	 
	@Override
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < xList.size() - 1; i++) {
			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1));
		}
	}

}
