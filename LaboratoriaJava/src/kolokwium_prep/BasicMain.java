package kolokwium_prep;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import lab08.ChartsFrame;

public class BasicMain {

	public static void main(String[] args) {
//		FlatLightLaf.setup();
//		UIManager.put( "Button.arc", 5 );
		
		BorderLayoutExampleFrame frame = new BorderLayoutExampleFrame();
		frame.setVisible(true);

	}

}
