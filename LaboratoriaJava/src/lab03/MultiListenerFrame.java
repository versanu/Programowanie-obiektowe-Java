package lab03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;

public class MultiListenerFrame extends JFrame implements ActionListener {

	public MultiListenerFrame() {
		super();
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		
		JPanel panelGorny = new JPanel();
        add(panelGorny, BorderLayout.NORTH);
        
        JSlider suwak = new JSlider(JSlider.HORIZONTAL, 0, 100, 0);
        panelGorny.add(suwak);
        suwak.setPaintTicks(true);
        suwak.setMajorTickSpacing(10);
        
        JPanel panelLewy = new JPanel();
        add(panelLewy, BorderLayout.WEST);
        panelLewy.setLayout(new GridLayout(3,1));
        
        JRadioButton r1 = new JRadioButton("Panel górny");
        JRadioButton r2 = new JRadioButton("Panel środkowy");
        JRadioButton r3 = new JRadioButton("Panel dolny");
        
        ButtonGroup bg=new ButtonGroup(); 
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        
        panelLewy.add(r1);
        panelLewy.add(r2);
        panelLewy.add(r3);

        JPanel panelDolny = new JPanel();
        add(panelDolny, BorderLayout.SOUTH);
        
        JButton przycisk1 = new JButton("Zmień kolor");
        panelDolny.add(przycisk1);
        
        JPanel panelPrawy = new JPanel();
        add(panelPrawy, BorderLayout.EAST);
        
        panelPrawy.setLayout(new GridLayout(7,1));
        JLabel etykietka = new JLabel("Wartość suwaka");
        panelPrawy.add(etykietka);
        
        JTextField poleTekstowe = new JTextField();
        panelPrawy.add(poleTekstowe);
        
        suwak.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				String value = String.format("%d", suwak.getValue());
				poleTekstowe.setText(value);
			}
		});
        
        
        JPanel panelSrodkowy = new JPanel();
        add(panelSrodkowy, BorderLayout.CENTER);
        
        
        przycisk1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Color newColor = JColorChooser.showDialog(null, "Wybierz kolor",getForeground())
			
				if(r1.isSelected()) { 
					Color kolor = JColorChooser.showDialog(null, "Wybierz kolor", panelGorny.getForeground());
					panelGorny.setBackground(kolor);
				} else if(r2.isSelected()) {
					Color kolor = JColorChooser.showDialog(null, "Wybierz kolor", panelSrodkowy.getForeground());
					panelSrodkowy.setBackground(kolor);
				}else {
					Color kolor = JColorChooser.showDialog(null, "Wybierz kolor", panelDolny.getForeground());
					panelDolny.setBackground(kolor);
				}
			}	
		});
        
        
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		MultiListenerFrame ramka = new MultiListenerFrame();
		
		ramka.setVisible(true);
		
	}

}
