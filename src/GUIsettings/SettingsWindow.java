package GUIsettings;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.AdapterDay;
import DB.AdapterWeek;
import GUImeal.MealWindowBuilder;
import Model.Week;

public class SettingsWindow extends JFrame{
	
	//String
	private static String title = "Asetukset";
	
	protected static String tab1title = "ASD";
	protected static String tab2title = "ASD";
	
	//Dimensions
	protected static int windowWidth = 500;
	protected static int windowHeigth = 500;
		
	protected static int fieldLength = 200;
	protected static int TFheigth = 30;
	protected static int TAheigth = 60;
		
		//View
		protected static JPanel tab1panel = new JPanel();
		protected static JPanel tab2panel = new JPanel();
		protected static JTabbedPane tabbedPane = new JTabbedPane();
		
		protected static JPanel inner = new JPanel();
		protected static Box contents = Box.createVerticalBox();
		
		protected static JPanel buttonPanel = new JPanel(new GridLayout(1,2));
		
		protected static JLabel Lname = new JLabel("Nimi:      ");
		protected static JLabel Ldescription = new JLabel("Kuvaus: ");
		protected static JTextField TFname = new JTextField();
		protected static JTextArea TAdescription = new JTextArea();
		
		protected static JButton BTready = new JButton("Valmis");
		protected static JButton BTcancel = new JButton("Peruuta");
		
		
		//DB
		protected static  AdapterWeek aweek= new AdapterWeek();
		protected static  AdapterDay aday = new AdapterDay();
		
		//Content
		protected static Week editWeek = null;


	public SettingsWindow() {
		//Build window
		super(title);
		
		

		SettingsWindowBuilder.buildWindow(); //Builds window
		
		this.getContentPane().add(inner);
		setSize(windowWidth,windowHeigth);
		
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Component listeners
		
		
	}

}
