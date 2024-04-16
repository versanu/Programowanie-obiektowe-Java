package lab06.zadanie1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.*;
import javax.swing.*;


public class PrimaryWindow extends JFrame {
	
	public PrimaryWindow() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//Kod ustawiający automatyczny rozmiar okna. - Mateusz
		SetWindowSize windowSize = new SetWindowSize(this);
		int windowWidth = windowSize.getAutoWindowWidth();
		int windowHeight = windowSize.getAutoWindowHeigth();
		setSize(windowWidth, windowHeight);
		
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//Środkowy panel
		JPanel srodkowyPanel = new JPanel(new FlowLayout());
		add(srodkowyPanel, BorderLayout.CENTER);
		FirstRunnableJButton button1 = new FirstRunnableJButton();
		srodkowyPanel.add(button1);
		
		String[] innyTekst = { "inny", "tekst", "do", "animowanego",
		"przycisku" };
		
		FirstRunnableJButton button2 = new FirstRunnableJButton(innyTekst, 100);
		srodkowyPanel.add(button2);
		
		String[] kolejnyTekst = { "ten", "przycisk", "zmienia", "kolory"};
		
		SecondRunnableJButton button3 = new SecondRunnableJButton();
		srodkowyPanel.add(button3);
//		ColorChangingPanel kolorPanel = new ColorChangingPanel();
//		srodkowyPanel.add(kolorPanel);
		
//		ColorChangingJLabel label = new ColorChangingJLabel(;
//		srodkowyPanel.add(label);
		
		ExecutorService exec = Executors.newFixedThreadPool(4);
		// Executors.newSingleThreadExecutor();

		exec.execute(button1);
		exec.execute(button2);
//		exec.execute(label);
		exec.execute(button3);

		exec.shutdown();
		
		final ScheduledExecutorService scheduler = 
			       Executors.newScheduledThreadPool(2);
		
		scheduler.schedule(new Runnable() {
            @Override
			public void run() { 
            scheduler.shutdownNow();
            System.exit(0);}
        }, 5, SECONDS);
		
		
		
		
		
		
		//Górny panel
		JPanel gornyPanel = new JPanel();
		add(gornyPanel, BorderLayout.NORTH);
		gornyPanel.setLayout(new FlowLayout());
		
		
		
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

