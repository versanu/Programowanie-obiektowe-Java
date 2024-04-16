package lab06.zadanie1;

import java.awt.Color;

import javax.swing.JButton;

public class SecondRunnableJButton extends JButton implements Runnable {
	
	int pauza = 1000;
	boolean czynny = true;
	
	SecondRunnableJButton() {
		super();
		setText("przycisk");
	}

	@Override
	public void run() {


		while (czynny) {
			 setBackground(new Color(
			 (float)Math.random(),(float)Math.random(),(float)Math.random()
			 ));
			 
			 System.out.println("test");

			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
}

