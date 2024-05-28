package lab08;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class ChartsMain {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put( "Button.arc", 5 );
		
		ChartsFrame frame = new ChartsFrame();
		frame.setVisible(true);

	}

}
