package GUIinfo;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateInfoWindow {
	
		static File htmlFile = new File("Resources/ohjeet.html");


	public CreateInfoWindow() {

	}

	
	//Open help guide in browser
	public static void guideInBrowser() {
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
