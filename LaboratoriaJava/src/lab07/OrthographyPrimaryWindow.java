package lab07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import lab04.PanelRysowania;
import lab05.PrimaryWindow;

public class OrthographyPrimaryWindow extends JFrame {
	
	String loadedText = "";
	String changedText = "";
	FileReader fr = null;
	
	public OrthographyPrimaryWindow() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//Górny panel
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new FlowLayout());
		JButton loadButton = new JButton("Choose file to load");
		gornyPanel.add(loadButton);
		JButton checkButton = new JButton("Check orthography");
		gornyPanel.add(checkButton);
		JButton saveButton = new JButton("Save to file");
		gornyPanel.add(saveButton);
		JButton italicsButton = new JButton("Change style to Italics");
		gornyPanel.add(italicsButton);
		JButton boldButton = new JButton("Change style to Bold");
		gornyPanel.add(boldButton);
		
		//Środkowy panel
		JPanel srodkowyPanel = new JPanel();
		add(srodkowyPanel, BorderLayout.CENTER);
		JTextPane plytkaTekstu = new JTextPane();
		plytkaTekstu.setPreferredSize(new Dimension(800, 500));
		srodkowyPanel.add(plytkaTekstu);

		
		
		
		//Action Listeners
		loadButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser fC = new JFileChooser();
				fC.setDialogTitle("Wybierz plik");
				int returnVal = fC.showOpenDialog(srodkowyPanel);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fC.getSelectedFile();
					
					try {
						fr = new FileReader(file);
						BufferedReader bfr = new BufferedReader(fr);

						// ODCZYT KOLEJNYCH LINII Z PLIKU:
						while ((loadedText = bfr.readLine()) != null) {
							loadedText = loadedText.replaceAll("[ó,u,ż,h]", "?");
							loadedText = loadedText.replaceAll("rz", "?");
							loadedText = loadedText.replaceAll("ch", "?");
							plytkaTekstu.setText(loadedText);
						}

						// ZAMYKANIE PLIKU
						fr.close();
					} catch (Exception r) {
						System.out.println("BLAD IO!");
						System.exit(1);
					}
		            
		        } else {
		        	JOptionPane.showMessageDialog(OrthographyPrimaryWindow.this, "File not loaded.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				changedText = plytkaTekstu.getText();
				
				JFileChooser fC = new JFileChooser();
				fC.setDialogTitle("Wybierz plik");
				int returnVal = fC.showSaveDialog(srodkowyPanel);
				
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File file = fC.getSelectedFile();
					
					FileWriter fw = null;

					try {
						fw = new FileWriter(file);
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(changedText);
						bw.close();
						//fw.close(); - wystarczy zamknąć zewnętrzny
					} catch (IOException r) {
						r.printStackTrace();
					}
		            
		        } else {
		        	JOptionPane.showMessageDialog(OrthographyPrimaryWindow.this, "Filed not saved.", "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
			}
		});
		
		italicsButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet attributeSet = new SimpleAttributeSet();
				StyleConstants.setItalic(attributeSet, true);
				plytkaTekstu.setCharacterAttributes(attributeSet, true);
				
			}
		});
		
		boldButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleAttributeSet attributeSet = new SimpleAttributeSet();
				StyleConstants.setBold(attributeSet, true);
				plytkaTekstu.setCharacterAttributes(attributeSet, true);
				
			}
		});
		
		
		
		
		//Menu
		JMenuBar menuBar;
		JMenu menu;
		
		menuBar = new JMenuBar();
		menu = new JMenu("Main menu");
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
