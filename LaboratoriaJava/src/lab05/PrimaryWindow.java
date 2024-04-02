package lab05;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import lab04.PanelRysowania;

public class PrimaryWindow extends JFrame {
	
	public PrimaryWindow() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,600);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//Środkowy panel
		JPanel srodkowyPanel = new JPanel();
		add(srodkowyPanel, BorderLayout.CENTER);
		
		//Górny panel
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new FlowLayout());
		
		//Dolny panel
		JPanel dolnyPanel = new JPanel();
		add(dolnyPanel, BorderLayout.SOUTH);
		
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
	}
}
