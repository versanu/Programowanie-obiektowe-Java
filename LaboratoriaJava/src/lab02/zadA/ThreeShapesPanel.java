package lab02.zadA;

import java.awt.Graphics;
import java.awt.*;
import java.awt.LayoutManager;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ThreeShapesPanel extends JPanel {

	public ThreeShapesPanel() {
		// TODO Auto-generated constructor stub
	}

	int r1= (int)(Math.random()*256);
	int r2= (int)(Math.random()*256);
	int r3= (int)(Math.random()*256);
	int g1= (int)(Math.random()*256);
	int g2= (int)(Math.random()*256);
	int g3= (int)(Math.random()*256);
	int b1= (int)(Math.random()*256);
	int b2= (int)(Math.random()*256);
	int b3= (int)(Math.random()*256);
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		
		
		
		Color randColor1 = new Color(r1, g1, b1);
		Color randColor2 = new Color(r2, g2, b2);
		Color randColor3 = new Color(r3, g3, b3);
		
		g.setColor(randColor1);
		g.fillOval(200, 200, 150, 160);
		
		g.setColor(randColor2);
		g.fillArc(100, 100, 50, 50, 0, 90);
		
		g.setColor(randColor3);
		g.fillRect(350,350, 50, 50);
		
	}

	public static void main(String[] args) {
		CloseableFrame frame = new CloseableFrame();
		frame.setLayout(new GridLayout(1,2));
		
		JPanel panel1 = new JPanel();
		ThreeShapesPanel panel2 = new ThreeShapesPanel();
		
		JButton button1 = new JButton("Przycisk 1");
		JButton button2 = new JButton("Przycisk 2");
		JButton button3 = new JButton("Przycisk 3");
		JButton button4 = new JButton("Przycisk 4");
		panel1.add(button1);
		panel1.add(button2);
		panel1.add(button3);
		panel1.add(button4);
		
		frame.add(panel1);
		frame.add(panel2);
		
		frame.setVisible(true);
	}

}
