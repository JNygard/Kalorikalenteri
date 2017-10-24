package GUIweek;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GUImain.DataView;
import GUImain.MainWindowBuilder;

public class CreateWeekWindow extends JFrame{
	
	//String
	private static String title = "Viikkoaikataulu";
	
	
	//Dimensions
	private static int windowWidth = 300;
	private static int windowHeigth = 200;
	
	private static int fieldLength = 200;
	private static int TFheigth = 30;
	private static int TAheigth = 60;
	
	//View
	protected static JPanel inner = new JPanel();
	protected static Box contents = Box.createVerticalBox();
	
	protected static JPanel buttonPanel = new JPanel(new GridLayout(1,2));
	
	protected static JLabel Lname = new JLabel("Nimi:      ");
	protected static JLabel Ldescription = new JLabel("Kuvaus: ");
	protected static JTextField TFname = new JTextField();
	protected static JTextArea TAdescription = new JTextArea();
	
	protected static JButton BTready = new JButton("Valmis");
	protected static JButton BTcancel = new JButton("Peruuta");

	public CreateWeekWindow() {
		super(title);
		
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		 buildWindow() ;
		
		this.getContentPane().add(inner);
		

		
	}
	
	
	private void buildWindow() {
		Box b1 = Box.createHorizontalBox();
		TFname.setPreferredSize(new Dimension(this.fieldLength,this.TFheigth));
		b1.add(Lname);
		b1.add(TFname);
		contents.add(b1);
		
		Box b2 = Box.createHorizontalBox();
		
		TAdescription.setPreferredSize(new Dimension(this.fieldLength,this.TAheigth));
		b2.add(Ldescription);
		b2.add(TAdescription);
		contents.add(b2);
		
		inner.add(contents);
		
		buttonPanel.add(BTcancel);
		buttonPanel.add(BTready);
		inner.add(buttonPanel);
		
		
	}

}
