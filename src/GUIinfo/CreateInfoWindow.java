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

public class CreateInfoWindow extends JFrame{
	
		File htmlFile = new File("Resources/HELP.html");

		/*
		//Dimensions
		private static int windowWidth = 500;
		private static int windowHeigth = 700;
		
		private static int marginX = 50;
		private static int marginY = 10;
		
		private static int fieldLength = 200;
		private static int TFheigth = 30;
		private static int TAheigth = 60;
		
		//View
		protected static JPanel inner = new JPanel();
		protected static Box contents = Box.createVerticalBox();
		
		//
		protected static JLabel infoLabel1 = new JLabel();
		*/

	public CreateInfoWindow() {
		/*
		super(title);
		
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		 buildWindow();
		 //setListeners();
		
		this.getContentPane().add(inner);
		
		//Open in browser
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	/*
	//Build window
	private void buildWindow() {
		
		infoLabel1.setPreferredSize(new Dimension(windowWidth-marginX, windowHeigth-marginY));
		
		infoLabel1.setText(programHelp);
		inner.add(infoLabel1);
		
	}
	*/
	
	//Open help guide in browser
	public void guideInBrowser() {
		try {
			Desktop.getDesktop().browse(htmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
