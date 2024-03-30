package lab02.zadA;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ThreeButtonFrame extends JFrame {

	public ThreeButtonFrame() throws HeadlessException {
		super();
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		this.setLayout(new GridLayout(3,1));
		
		JButton button1 = new JButton("Zakończ");
		JButton button2 = new JButton("Ustaw rozmiar okna na 400x400px");
		JButton button3 = new JButton("KOCHAM ZIELONY");

		ActionListener exitListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
						
			}	
		};
		button1.addActionListener(exitListener);
		
		
		ActionListener FrameSize = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ThreeButtonFrame.this.setSize(400,400);
						
			}	
		};
		button2.addActionListener(FrameSize);

		ActionListener BackgroundColor = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				button2.setBackground(Color.BLUE);
						
			}	
		};
		button3.addActionListener(BackgroundColor);
		
		
		this.add(button1);
		this.add(button2);
		this.add(button3);
		
	}


	public static void main(String[] args) {
		ThreeButtonFrame ramka = new ThreeButtonFrame();
		
		ramka.setVisible(true);

	}

}
