package GUIsettings;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.AdapterDay;
import DB.AdapterWeek;
import DB.DBmanager;
import GUImeal.MealTab;
import GUImeal.MealWindowBuilder;
import Model.Week;

public class SettingsWindow extends JFrame{
	
	//String
	private static String title = "Asetukset";
	
	protected static String tab1title = "Tyhjenn� tiedot";
	protected static String tab2title = "ASD";
	
	//Dimensions
	protected static int windowWidth = 500;
	protected static int windowHeigth = 500;
	
	protected static int margin1X = 20;
	protected static int margin1Y = 20;
		
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
		
		//Tab1 view
		//protected static JLabel Lname = new JLabel("Nimi:      ");
		protected static JButton BTdefaultData = new JButton("Tyhjenn� tiedot");
		
		
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
		setTab1Listeners() ;
		
	}
	
	
	//LISTENERS
	private void setTab1Listeners() {
		BTdefaultData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Settings.formatProgramData()) {
					System.exit(0);
				}
			}});
	}
	
	
	///////////////////////////////////////////////7---
	
	//Confirm dialog
	public static boolean confirm(String title, String msg) {
		Object[] options = {"Peruuta", "Kyll�"};
		int n = JOptionPane.showOptionDialog(inner,msg,title,
		    JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,
		    null,options,options[1]);
				
		if(n==1) {
			return true;
		}
		return false;
	}
	
	//Show dialog message
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(inner, msg);
	}
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}


	

}
