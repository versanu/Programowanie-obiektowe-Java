package lab06.zadanie1;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class ColorChangingJLabel extends JLabel implements Runnable {
	
	Color color;
	boolean active = true;
	int timeDelta = 100;
	
	public ColorChangingJLabel() {
		this.setText("Etykietka zmieniająca kolor");
		this.setBackground(Color.GREEN);
	}
	
	

	@Override
	public void run() {
		
		int ColorR = 100;
		int ColorG = 100;
		int ColorB = 100;
		
		
		
		while (active) {
			
			
			if (ColorR > 225) {
				ColorR = 100;
			
			}
			
			try {
				Thread.sleep(timeDelta);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	
}
