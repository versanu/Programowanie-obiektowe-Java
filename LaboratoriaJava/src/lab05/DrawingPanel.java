package lab05;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	Pencil pencilLine = new Pencil();
	ArrayList<Shape> drawnShapes = new ArrayList<Shape>();
	private boolean isPencil = true;
	
	public boolean isPencil() {
		return isPencil;
	}

	public void setPencil(boolean isPencil) {
		this.isPencil = isPencil;
	}

	Rectangle drawnRectangle = new Rectangle();
	
	public DrawingPanel() {
		super();
		setPreferredSize(new Dimension(600,600));
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if(isPencil) {
					int x = e.getX();
					int y = e.getY();
					pencilLine.addPoint(x, y);
				} else { 
					int x = e.getX();
					int y = e.getY();
					drawnRectangle.addPoint(x, y);
				}
				repaint();
				
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				if (isPencil) {
					pencilLine = new Pencil();
					drawnShapes.add(pencilLine);
				} else {
					drawnRectangle = new Rectangle();
					drawnShapes.add(drawnRectangle);
				}
				
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
//				if(!isPencil) {
//					drawnRectangle.setStartX() = e.getX();
//				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLACK);
		
		for (Shape pencilLine: drawnShapes) pencilLine.draw(g2d);
		for (Shape drawnRectangle : drawnShapes) drawnRectangle.draw(g2d);
	}
}
