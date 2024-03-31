package lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

public class OknoWielokaty extends JFrame implements ActionListener {

	private JRadioButton regButton, randButton;
	
	public OknoWielokaty() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		
		//Menu
		JMenuBar menuBar;
		JMenu menu;
		
		menuBar = new JMenuBar();
		menu = new JMenu("Menu glowne");
		menuBar.add(menu);
		JMenuItem author = new JMenuItem("Autor");
		author.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(author, "Mateusz Roszkowski");
				
			}
		});
		menu.add(author);
		menu.addSeparator();
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);	
			}
		});
		menu.add(exit);
		setJMenuBar(menuBar);
		
		//Górny panel
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);
		gornyPanel.add(slider);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(10);
		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JButton przyciskRysuj = new JButton("Rysuj");
		gornyPanel.add(przyciskRysuj);
		
		//Dolny panel
		JPanel dolnyPanel = new JPanel();
		add(dolnyPanel, BorderLayout.SOUTH);
		
		//Lewy panel
		JPanel lewyPanel = new JPanel();
		add(lewyPanel, BorderLayout.WEST);
		lewyPanel.setLayout(new GridLayout(2,1));
		
		regButton = new JRadioButton("Regular");
		randButton = new JRadioButton("Random");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(regButton);
		bg.add(randButton);
		
		regButton.addActionListener(this);
		randButton.addActionListener(this);
		
		lewyPanel.add(regButton);
		lewyPanel.add(randButton);
		
		
		//Prawy panel
		JPanel prawyPanel = new JPanel();
		add(prawyPanel, BorderLayout.EAST);
		
		//Środkowy panel
		JPanel srodkowyPanel = new JPanel();
		add(srodkowyPanel, BorderLayout.CENTER);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(regButton.isSelected()) {
			
		} else {
			
		}
		
	}
	
	
	public static void main(String[] args) {
		OknoWielokaty frame = new OknoWielokaty();
		frame.setVisible(true);

	}


	

}
