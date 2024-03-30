package lab02.zadA;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

public class CloseableFrame extends JFrame {

	public CloseableFrame() throws HeadlessException {
		this.setSize(640, 480);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		CloseableFrame okno = new CloseableFrame();
		okno.setVisible(true);
		
		

	}

}
