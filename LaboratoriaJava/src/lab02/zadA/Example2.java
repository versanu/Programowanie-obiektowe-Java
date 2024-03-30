package lab02.zadA;

import javax.swing.JButton;

public class Example2 {

	public Example2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		CloseableFrame frame = new CloseableFrame();
		
		JButton button1 = new JButton("Przycisk 1");
		frame.add(button1);
				
		JButton button2 = new JButton("Przycisk 2");
		frame.add(button2);

		frame.setVisible(true);

	}

}
