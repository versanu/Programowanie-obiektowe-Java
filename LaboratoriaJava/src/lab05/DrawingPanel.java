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
	
	ArrayList<Shape> drawnShapes = new ArrayList<Shape>();
	private Shape currentShape;
	private boolean isPencil = true;
	
	public void clearDrawnShapes() {
		drawnShapes.clear();
		repaint();
	}

	public void setPencil(boolean isPencil) {
		this.isPencil = isPencil;
	}

	public Color getLineColor() {
		return PrimaryWindow.lineColor;
	}

	public int getLineWidth() {
		return PrimaryWindow.lineWidth;
	}

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
					((Pencil) currentShape).addPoint(e.getX(), e.getY());
					repaint();
				} else {
					((Rectangle) currentShape).setCurrentPoint(e.getX(), e.getY());
					repaint();
				}
				
				
			}
		});
		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				drawnShapes.add(currentShape);
                currentShape = null;
                repaint();
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				if(isPencil) {
					currentShape = new Pencil(getLineColor(), getLineWidth());
                    ((Pencil) currentShape).addPoint(e.getX(), e.getY());
				} else {
					currentShape = new Rectangle(getLineColor(), getLineWidth());
					((Rectangle) currentShape).setStartPoint(e.getX(), e.getY());
				}
				
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
				
			}
		});
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		
		for (Shape shape: drawnShapes) shape.draw(g2d);
		
		if (currentShape != null) {
            currentShape.draw(g2d);
        }
	}
}
