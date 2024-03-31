package lab04;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PanelRysowania extends JPanel {
	int lineWidth;
	int vertexNumber;
	Color backgroundColor;
	Color lineColor;
	
	public PanelRysowania() {
		System.out.println("Default constructor has initiated");
	}

	public PanelRysowania(int lineWidth, int vertexNumber, Color backgroundColor, Color lineColor) {
		super();
		this.lineWidth = lineWidth;
		this.vertexNumber = vertexNumber;
		this.backgroundColor = backgroundColor;
		this.lineColor = lineColor;

	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
	}	
	
}


