package lab05;

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
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import lab04.PanelRysowania;

public class PrimaryWindow extends JFrame {
	
	public static Color lineColor = Color.BLACK;
	public static int lineWidth = 2;
	
	public PrimaryWindow() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(1000,800);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//Środkowy panel
		JPanel srodkowyPanel = new JPanel();
		add(srodkowyPanel, BorderLayout.CENTER);
		DrawingPanel drawingPanel = new DrawingPanel();
		srodkowyPanel.add(drawingPanel);
		
		//Górny panel
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new FlowLayout());
		
		JButton pencilButton = new JButton("Pencil");
		gornyPanel.add(pencilButton);
		
		pencilButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.setPencil(true);
			}
		});
		
		JButton rectangleButton = new JButton("Rectangle");
		gornyPanel.add(rectangleButton);
		
		rectangleButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.setPencil(false);
			}
		});
		
		JButton clearPanel = new JButton("Clear workspace");
		gornyPanel.add(clearPanel);
		
		clearPanel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				drawingPanel.clearDrawnShapes();
				drawingPanel.repaint();
				
			}
		});
		
		JButton pickColor = new JButton("Change color");
		gornyPanel.add(pickColor);
		pickColor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				lineColor = JColorChooser.showDialog(srodkowyPanel, "Wybierz kolor lini", lineColor);
				
			}
		});
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 30, 2);
		gornyPanel.add(slider);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(5);
		slider.setPaintLabels(true);
		
		JTextField poleTekstowe = new JTextField();
		poleTekstowe.setPreferredSize(new Dimension(25, 25));
		poleTekstowe.setEditable(false);
        gornyPanel.add(poleTekstowe);
        		
		slider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lineWidth = slider.getValue();
				String value = String.format("%d", lineWidth);
				poleTekstowe.setText(value);
				
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
		
		menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem saveToFile = new JMenuItem("Save");
		saveToFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showSaveDialog(PrimaryWindow.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageSaver.saveDrawingPanel(drawingPanel, selectedFile);
                }
			}
		});
		menu.add(saveToFile);
		
		JMenuItem loadFile = new JMenuItem("Open");
		loadFile.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				int result = fileChooser.showOpenDialog(PrimaryWindow.this);
				if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    try {
                    	BufferedImage image = ImageIO.read(selectedFile);
                    	drawingPanel.setBackgroundImage(image);
                    } catch (IOException ex) {
                    	ex.printStackTrace();
                        JOptionPane.showMessageDialog(PrimaryWindow.this, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
				}
			}
		});
		menu.add(loadFile);
		
		setJMenuBar(menuBar);
	}
}
