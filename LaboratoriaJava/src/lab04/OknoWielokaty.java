package lab04;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

public class OknoWielokaty extends JFrame implements ActionListener {
	private JRadioButton regButton, randButton;
	private PanelRysowania panelRysowania;
	
	public OknoWielokaty() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,600);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//Środkowy panel
		JPanel srodkowyPanel = new JPanel();
		add(srodkowyPanel, BorderLayout.CENTER);
		panelRysowania = new PanelRysowania();
		srodkowyPanel.add(panelRysowania);
		
		//Górny panel
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new FlowLayout());
		
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
				panelRysowania.setVertexNumber(slider.getValue());
				String value = String.format("%d", slider.getValue());
				poleTekstowe.setText(value);
				
				if(randButton.isSelected()) {
					panelRysowania.setRegular(false);
				} else {
					panelRysowania.setRegular(true);		
				}
				
				repaint();
				
			}
		});
		
		//Dolny panel
		JPanel dolnyPanel = new JPanel();
		add(dolnyPanel, BorderLayout.SOUTH);
		JButton bgColorButton = new JButton("Background color");
		JButton lnColorButton = new JButton("Line color");
		dolnyPanel.add(bgColorButton);
		dolnyPanel.add(lnColorButton);
		
		bgColorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRysowania.setBackgroundColor(JColorChooser.showDialog(srodkowyPanel, "Wybierz kolor tła", Color.WHITE));
				repaint();
			}
		});
		
		lnColorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRysowania.setLineColor(JColorChooser.showDialog(srodkowyPanel, "Wybierz kolor lini", Color.WHITE));
				repaint();
			}
		});
		
		
		//Lewy panel
		JPanel lewyPanel = new JPanel();
		add(lewyPanel, BorderLayout.WEST);
		lewyPanel.setLayout(new GridLayout(2,1));
		
		regButton = new JRadioButton("Regular");
		randButton = new JRadioButton("Random");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(regButton);
		bg.add(randButton);
		
		lewyPanel.add(regButton);
		lewyPanel.add(randButton);
		
		//Prawy panel
		JPanel prawyPanel = new JPanel();
		add(prawyPanel, BorderLayout.EAST);
		
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
		
		JMenu lineWidthMenu = new JMenu("Line width");
		menuBar.add(lineWidthMenu);
		
		JMenuItem lineWidthOpt1 = new JMenuItem("1 pt");
		lineWidthOpt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRysowania.setLineWidth(1);
				repaint();
			}
		});
		lineWidthMenu.add(lineWidthOpt1);

		JMenuItem lineWidthOpt2 = new JMenuItem("2 pt");
		lineWidthOpt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRysowania.setLineWidth(2);
				repaint();
			}
		});
		lineWidthMenu.add(lineWidthOpt2);
		
		JMenuItem lineWidthOpt5 = new JMenuItem("5 pt");
		lineWidthOpt5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRysowania.setLineWidth(5);
				repaint();
			}
		});
		lineWidthMenu.add(lineWidthOpt5);
		
		JMenuItem lineWidthOpt10 = new JMenuItem("10 pt");
		lineWidthOpt10.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelRysowania.setLineWidth(10);
				repaint();
			}
		});
		lineWidthMenu.add(lineWidthOpt10);
		
		
		setJMenuBar(menuBar);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(regButton.isSelected()) {
			panelRysowania.setRegular(true);
		} else {
			panelRysowania.setRegular(false);
		}
	}
	
	
	public static void main(String[] args) {
		OknoWielokaty frame = new OknoWielokaty();
		frame.setVisible(true);

	}
}
