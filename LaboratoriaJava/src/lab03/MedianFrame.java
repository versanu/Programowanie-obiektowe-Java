package lab03;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class MedianFrame extends JFrame {
	
	ArrayList<Integer> nazwaListy = new ArrayList<Integer>();
	
	public MedianFrame() {
		super();
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600,500);
		this.setLayout(new BorderLayout());
		
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new GridLayout(1,4));
		
		JTextField poleTekstowe = new JTextField();
        gornyPanel.add(poleTekstowe);
        
        JButton przyciskDodaj = new JButton("Dodaj");
        gornyPanel.add(przyciskDodaj);
        
        JButton przyciskMediana = new JButton("Mediana");
        gornyPanel.add(przyciskMediana);
        
        double wynik = 0.0;
        JLabel labelWynik = new JLabel("= "+String.valueOf(wynik));
        gornyPanel.add(labelWynik);
		
		JPanel dolnyPanel = new JPanel();
		add(dolnyPanel, BorderLayout.SOUTH);
		
		

	}

	public static void main(String[] args) {
		MedianFrame frame = new MedianFrame();
		frame.setVisible(true);

	}

}
