package GUIinfo;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateInfoWindow extends JFrame{
	
	//String
		private static String title = "Ohje";
		protected static String programHelp = "<html>\r\n" + 
				"    <body>\r\n" + 
				"        <h2>Sovelluksen avulla k‰ytt‰j‰ voi rakentaa itselleen viikkoruoka-aikatauluja. </h2>\r\n" + 
				"        <h2>Elintarvike</h2>\r\n" + 
				"        <p>K‰ytt‰j‰ voi syˆtt‰‰ sovellukseen ruoka-aineita, joita\r\n" + 
				"        tavallisesti k‰ytt‰‰ ja niiden kalorim‰‰r‰n,\r\n" + 
				"        Lis‰‰ > Hallitse aterioita > Hallitse elintarvikkeita.\r\n" + 
				"        </p>\r\n" + 
				"        <h2>Ateria</h2>\r\n" + 
				"        <p>\r\n" + 
				"        K‰ytt‰j‰ voi n‰ist‰ elintarvikkeista koota\r\n" + 
				"            itselleen aterioita, joita tavallisesti syˆ, Lis‰‰ > Hallitse aterioita.\r\n" + 
				"        </p>\r\n" + 
				"        <h2>Viikkon‰kym‰</h2>\r\n" + 
				"        <img src=\"images/viikko.png\">\r\n" + 
				"        <p>\r\n" + 
				"        Kun k‰ytt‰j‰ on koonnut itselleen aterian/aterioita, voi h‰n liitt‰‰\r\n" + 
				"            aterioita viikkon‰kym‰‰n valitsemalla jonkin solun viikkon‰kym‰st‰, jolloin\r\n" + 
				"        </p>\r\n" + 
				"				\r\n" + 
				"    </body>\r\n" + 
				"</html>";
		
		
		
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

	public CreateInfoWindow() {
		super(title);
		
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		 buildWindow();
		 //setListeners();
		
		this.getContentPane().add(inner);
	}
	
	//Build window
	private void buildWindow() {
		
		infoLabel1.setPreferredSize(new Dimension(windowWidth-marginX, windowHeigth-marginY));
		
		infoLabel1.setText(programHelp);
		inner.add(infoLabel1);
		
	}

}
