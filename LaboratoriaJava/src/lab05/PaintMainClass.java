package lab05;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class PaintMainClass {

	public static void main(String[] args) {
		FlatLightLaf.setup();
		UIManager.put( "Button.arc", 5 );
		
		PrimaryWindow frame = new PrimaryWindow();
		frame.setVisible(true);
	}

}
