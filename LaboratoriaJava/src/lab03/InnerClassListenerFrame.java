package lab03;

import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class InnerClassListenerFrame extends JFrame {
	
    // Pola klasy InnerClassListenerFrame
static final int SLIDER_MIN = -100;
static final int SLIDER_MAX = 100;
static final int SLIDER_INIT = 0;

    JSlider slider;
    JLabel label;

    // Konstruktor klasy InnerClassListenerFrame
public InnerClassListenerFrame() throws HeadlessException {
	this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	this.setSize(600,50);
	
	slider = new JSlider(JSlider.HORIZONTAL, SLIDER_MIN, SLIDER_MAX, SLIDER_INIT);
	this.add(slider, BorderLayout.PAGE_START);
	
	label = new JLabel(String.format("%d", slider.getValue()));
	this.add(label);
	
	slider.addChangeListener(new ChangeListener() {
		
		@Override
		public void stateChanged(ChangeEvent e) {
			String value = String.format("%d", slider.getValue());
			label.setText(value);
			
		}
	});
}

	


public static void main(String[] args) {
	InnerClassListenerFrame frame = new InnerClassListenerFrame();
	//ChangeListener listener = frame.new ();
	
	frame.setVisible(true);
}

}
