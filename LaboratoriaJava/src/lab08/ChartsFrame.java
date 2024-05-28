package lab08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class ChartsFrame extends JFrame {
	
	public ChartsFrame() {
		setSize(new Dimension(1000, 600));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		int chartMaxDomainValue = 5;
		int chartMaxRangeValue = 1;
		double samplingFreq = 0.01;
		
		Random rand = new Random();
		
		JMenuBar menuBar = new JMenuBar();
        JMenu functionMenu = new JMenu("Funkcje");
        JMenuItem sinButton = new JMenuItem("Funkcja Sinus");
        JMenuItem cosButton = new JMenuItem("Funkcja Cosinus");
        JMenuItem linearButton = new JMenuItem("Funkcja Liniowa");
        JMenuItem polynomialButton = new JMenuItem("Wielomian");
        JMenuItem logButton = new JMenuItem("Funkcja logarytmiczna");
        functionMenu.add(sinButton);
        functionMenu.add(cosButton);
        functionMenu.add(linearButton);
        functionMenu.add(polynomialButton);
        functionMenu.add(logButton);
        
        menuBar.add(functionMenu);
        setJMenuBar(menuBar);
		
		XYSeries series = new XYSeries("Dane");
		
		sinButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!series.isEmpty()) {
					series.clear();
		        }
				int randomFreq = rand.nextInt(10);
				for (double i = -chartMaxDomainValue; i < chartMaxDomainValue; i += samplingFreq) {
					series.add(i, Math.sin(randomFreq*i));
				}
			}
		});
		
		 cosButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!series.isEmpty()) {
					series.clear();
		        }
				int randomFreq = rand.nextInt(10);
				for (double i = -chartMaxDomainValue; i < chartMaxDomainValue; i += samplingFreq) {
					series.add(i, Math.cos(randomFreq*i));
				}
			}
		});
		 
		 linearButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if (!series.isEmpty()) {
						series.clear();
			        }
					double aRand = rand.nextDouble(10) - 5;
					double bRand = rand.nextDouble(0.5);
					for (double i = -chartMaxDomainValue; i < chartMaxDomainValue; i += samplingFreq) {
						series.add(i, (aRand * i) + bRand);
					}
					ChartsFrame.this.repaint();
				}
			});
		
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series);
		
		JFreeChart chart = ChartFactory.createXYLineChart(
				"Wykres XY",//Tytul
				"Opis osi X", // opisy osi
				"Opis osi Y", 
				dataset, // Dane 
				PlotOrientation.VERTICAL,
				true, // legenda
				true, // tooltips
				false
			);
		
		XYPlot plot = (XYPlot) chart.getPlot();
        ValueAxis xAxis = plot.getDomainAxis();
        xAxis.setRange(-chartMaxDomainValue, chartMaxDomainValue);
        
        ValueAxis yAxis = plot.getRangeAxis();
        yAxis.setAutoRange(false);
        yAxis.setRange(-chartMaxRangeValue, chartMaxRangeValue);
		
		ChartPanel chartPanel = new ChartPanel(chart);
		this.getContentPane().add(chartPanel);
		
	}

}
