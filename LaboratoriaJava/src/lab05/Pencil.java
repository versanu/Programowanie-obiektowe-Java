package lab05;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pencil extends Shape {
	
	 private List<Integer> xList;
	 private List<Integer> yList;

	 public Pencil(Color lineColor, int lineWidth) {
		 super(lineColor, lineWidth);
		 xList = new ArrayList<Integer>();
	     yList = new ArrayList<Integer>();
	}
	 
	public void addPoint(int x, int y) {
		xList.add(x);
		yList.add(y);
	}
	 
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(lineColor);
		g2d.setStroke(new BasicStroke(lineWidth));
		for (int i = 0; i < xList.size() - 1; i++) {
			g2d.drawLine(xList.get(i), yList.get(i), xList.get(i+1), yList.get(i+1));
		}
	}
	
	@Override
    public void setLineWidth(int lineWidth) {
        super.setLineWidth(lineWidth);
        System.out.println("Pencil line width updated: " + lineWidth);
    }
	
	@Override
    public void setColor(Color lineColor) {
        super.setColor(lineColor);
        System.out.println("Pencil line color updated: " + lineColor);
    }

}
