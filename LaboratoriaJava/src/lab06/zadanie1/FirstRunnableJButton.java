package lab06.zadanie1;

import javax.swing.JButton;

public class FirstRunnableJButton extends JButton implements Runnable {
	
	String[] tekst = { "To", "jest", "animowany", "przycisk" };
	int pauza = 1000;
	boolean czynny = true;
	
	FirstRunnableJButton() {
		super();
	}

	FirstRunnableJButton(String[] arg1, int arg2) {
		tekst = arg1;
		pauza = arg2;
	}

	@Override
	public void run() {

		int i = 0;

		while (czynny) {

			if (i < tekst.length - 1)
				i++;
			else
				i = 0;

			setText(tekst[i]);
			// setBackground(new Color(
			// (float)Math.random(),(float)Math.random(),(float)Math.random()
			// ));

			try {
				Thread.sleep(pauza);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
}
