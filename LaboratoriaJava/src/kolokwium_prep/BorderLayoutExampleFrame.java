package kolokwium_prep;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayoutExampleFrame extends JFrame {
	public BorderLayoutExampleFrame() {
		setSize(new Dimension(1000, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//NorthPanel
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);
		
		//CenterPanel
		JPanel centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new GridLayout(1,2));
		
		//WestPanel
		JPanel westPanel = new JPanel();
		add(westPanel, BorderLayout.WEST);
		
		//EastPanel
		JPanel eastPanel = new JPanel();
		add(eastPanel, BorderLayout.EAST);
		
		//SouthPanel
		JPanel southPanel = new JPanel();
		add(southPanel, BorderLayout.SOUTH);
	}

}
