package GUImain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import GUImeal.MealWindow;
import GUImeal.FoodTab;

public class MainWindow extends JFrame{
	
	MealWindow mw = new MealWindow();
	
	
	//String
	protected static String title = "Kalorikalenteri";
	
	//Dimensions
	protected static int windowWidth = 1100;
	protected static int windowHeigth = 600;
	protected static int maxBTNwidth = 600;
	protected static int maxBTNheigth = 30;
	
	//View components------------------------------------------------------------------------------------
	protected static JPanel inner = new JPanel( new BorderLayout(2,1));
	
	protected static JPanel weekPanel = new JPanel(new GridBagLayout());
	protected static Box dataPanel = Box.createVerticalBox();
	
	protected static Box dataWeekPanel = Box.createVerticalBox();
	protected static Box dataMealPanel = Box.createVerticalBox();
	
	
	//Menubar
	protected static JMenuBar menuBar = new JMenuBar();
	protected static JMenu menu1 = new JMenu("Tiedosto");
	protected static JMenu menu3 = new JMenu("Lis‰‰");
	protected static JMenu menu2 = new JMenu("Tietoja");
	protected static JMenuItem MIexit = new JMenuItem("Lopeta");
	protected static JMenuItem MIgoToMeal = new JMenuItem("Hallitse aterioita");
	protected static JMenuItem MIhelp = new JMenuItem("Apua");
	protected static JMenuItem MIinfo = new JMenuItem("Tietoja");
	
	//--Weekview  panel---------------------------------------------------------------------------------------------------------
	
	protected static String[] columnNameWeek = {"Klo", "Maanantai", "Tiistai", "Keskiviikko", "Torstai", "Perjantai", "Lauantai", "Sunnuntai"};
	protected static Object[][] dataWeek = {
		    {"0:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"1:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"2:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"3:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"4:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"5:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"6:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"7:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"8:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"9:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"10:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"11:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"12:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"13:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"14:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"15:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"16:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"17:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"18:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"19:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"20:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"21:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"22:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"23:00", "Pakke", " ", " ", " ", "Makke", " ", " "},
		    {"Yhteens‰", "1000 kcal", "1000 kcal", "1000 kcal", "1000 kcal", "1000 kcal", "1000 kcal", "1000 kcal"}
	};
	protected static JTable TBweekTable = new JTable(dataWeek, columnNameWeek);
	
	
	//--Data panel---------------------------------------------------------------------------------------------------------
	
	
	//Week
	protected static String[] testList = {"Wa", "asd", "daSDAF", "ASFGDGG"};
	protected static JList weekList = new JList();
	protected static JButton BTnewWeek = new JButton("Uusi");
	protected static JButton BTdeleteWeek = new JButton("Poista");
	protected static JButton BTeditWeek = new JButton("Muokkaa");
	protected static JTextArea TAweek = new JTextArea(2, 2);
	protected static JLabel LweekDescription = new JLabel("Kuvaus");
	protected static JLabel LweekTitle = new JLabel("ViikkoTitle");
	
	
	protected static String[] columnNames = {"Nimi","g/ml","Kcal"};
	protected static Object[][] data = {
		    {"Name", 50, 50},
		    {"Name2", 50, 50},
		    {"Name3", 50, 50},
		    {"Name4", 50, 50},
		    {"Name5", 50, 50},
		    {"Name6", 50, 50},
		    {"Name6", 50, 50},
		    {"Name6", 50, 50},
		    {"Name6", 50, 50},
		    {"Name6", 50, 50}
	};
		        
	//Meal/Hour
	protected static JList mealList = new JList();
	protected static JButton BTcontrolMeal = new JButton("Hallitse aterioita");
	protected static JButton BTemptyMeal = new JButton("Tyhjenn‰ ajankohta");
	protected static JTable TBmealIncridients = new JTable(data, columnNames);
	
	protected static JLabel LmealKcal = new JLabel("Yht: 150 Kcal");

	
	
	public MainWindow() {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		//Set menu
		MainWindowBuilder.buildMenu();
		this.setJMenuBar(menuBar);
		//Buildwindow
		MainWindowBuilder.buildView();
		
		this.getContentPane().add(inner);
		
		this.setVisible(true);
		setMenuListeners();
		setDataPanelListeners();
	}
	
	private void setMenuListeners(){
		//Exit
		MIexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}});
		//Go to meal edit
		MIgoToMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mw.setVisible(true);
			}});
		//Help
		MIhelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("Ohje");
			}});
		//Info
		MIinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("Tietoja");
			}});
	}
	
	private void setDataPanelListeners() {
		//List
		
		//BTN 
		BTnewWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("ASD");
			}});
		//BTN 
		BTdeleteWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("ASD");
			}});
		//BTN 
		BTeditWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("ASD");
			}});
		
		//BTN 
		BTcontrolMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mw.setVisible(true);
			}});
		//BTN 
		BTemptyMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage("ASD");
			}});
		
	}
	
	
	
	
	

	//Confirm dialog
	public static boolean confirm(String title, String msg) {
		Object[] options = {"Peruuta", "Kyll‰"};
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
