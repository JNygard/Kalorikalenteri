package GUImain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DB.AdapterDay;
import DB.AdapterFood;
import DB.AdapterFood100g;
import DB.AdapterMeal;
import DB.AdapterMealTime;
import DB.AdapterUser;
import DB.AdapterWeek;
import GUIinfo.CreateInfoWindow;
import GUImeal.MealWindow;
import GUIsettings.SettingsWindow;
import GUIweek.CreateWeekWindow;
import Model.Cell;
import Model.Food;
import Model.Meal;
import Model.MealTime;
import Model.Week;
import PrintableSchedule.Printer;
import PrintableSchedule.ScheduleBuilder;
import GUImeal.FoodTab;

public class MainWindow extends JFrame{
	
	public static ImageIcon icon = new ImageIcon("Resources/images/muscle2.png");
	
	//Windows
	MealWindow mw = new MealWindow();
	static CreateWeekWindow cww = new CreateWeekWindow();
	protected static CreateInfoWindow ciw = new CreateInfoWindow();
	protected static SettingsWindow csw = new SettingsWindow();
	
	
	
	//String
	protected static String title = "Kalorikalenteri";
	protected static String programAuthor = "T�m� sovellus on Oulun yliopiston tietojenk�sittelytieteen laitoksen "
			+ "K�ytt�liittym�ohjelmointi kurssille Joonas Nyg�rdin tekem� harjoitusty�. ";

	
	//Dimensions
	protected static int windowWidth = 1400;
	protected static int windowHeigth = 800;
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
	protected static JMenu menu3 = new JMenu("Lis��");
	protected static JMenu menu2 = new JMenu("Tietoja");
	protected static JMenuItem MIsettings = new JMenuItem("Asetukset");
	protected static JMenuItem MIexit = new JMenuItem("Lopeta");
	protected static JMenuItem MIprint = new JMenuItem("Tulosta");
	protected static JMenuItem MIaddWeek = new JMenuItem("Lis�� viikko");
	protected static JMenuItem MIgoToMeal = new JMenuItem("Hallitse aterioita");
	protected static JMenuItem MIhelp = new JMenuItem("Ohjeita");
	protected static JMenuItem MIinfo = new JMenuItem("Tietoja tekij�st�");
	
	//--Weekview  panel------     ------     ------     ------     ------     ------     ------     ------     ------     ------     ------     

	protected static JTable TBweekTable;
	protected static JScrollPane jsc;
	
	
	//--Data panel------     ------     ------     ------     ------     ------     ------     ------     ------     ------     ------     
	
	
	//Week
	protected static String[] testList = {"Wa", "asd", "daSDAF", "ASFGDGG"};
	protected static JList weekList = new JList();
	protected static JButton BTnewWeek = new JButton("Uusi");
	protected static JButton BTdeleteWeek = new JButton("Poista");
	protected static JButton BTeditWeek = new JButton("Muokkaa");
	protected static JTextArea TAweek = new JTextArea(2, 2);
	protected static JLabel LweekDescription = new JLabel("Kuvaus");
	protected static JLabel LweekTitle = new JLabel("ViikkoTitle");
	
	
	protected static String[] mealIncridientscolumnNames = {"Nimi","g/ml","Kcal"};
	protected static Object[][] mealIncridientsData = {};
		        
	//Meal/Hour
	protected static JLabel LselectedCell= new JLabel(" ");
	protected static JList mealList = new JList();
	protected static JButton BTcontrolMeal = new JButton("Hallitse aterioita");
	protected static JButton BTemptyMeal = new JButton("Tyhjenn� ajankohta");
	protected static JLabel LmealName = new JLabel(" ");
	protected static JTable TBmealIncridients = new JTable(mealIncridientsData, mealIncridientscolumnNames);
	protected static JLabel LmealKcal = new JLabel("Ateria: 0 Kcal");
	
	protected static JLabel LweekKcal = new JLabel("Viikossa: 0 Kcal.");
	protected static JLabel LdayKcalAVG = new JLabel("Keskim��rin: 0 Kcal/p�iv�");
	protected static JLabel LdayKcal = new JLabel("P�iv�: 0 Kcal.");
	
	//Contents-------------------------------------------------------------------------------------------------------------------------
	
	//DB
	protected static  AdapterFood100g af100= new AdapterFood100g();
	protected static  AdapterFood afood= new AdapterFood();
	protected static  AdapterMeal ameal= new AdapterMeal();
	
	protected static  AdapterWeek aweek= new AdapterWeek();
	protected static  AdapterMealTime amealTime= new AdapterMealTime();
	protected static  AdapterDay aday = new AdapterDay();
	
	//DataView
	protected static Week selectedWeek;
	protected static Meal selectedMeal;
	protected static MealTime selectedMealTime;
	protected static Food selectedFood;
	
	//Weekview
	protected static Cell selectedCell;
	
	
	
	public MainWindow() {
		super(title);
		
		//Check first time
		if(!AdapterUser.instructionCheck()){
			CreateInfoWindow.guideInBrowser();
		}
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(windowWidth,windowHeigth);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		//this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Set menu
		MainWindowBuilder.buildMenu();
		this.setJMenuBar(menuBar);
		
		//Buildwindow
		this.setIconImage(icon.getImage());
		MainWindowBuilder.buildView();
		this.getContentPane().add(inner);
		this.setVisible(true);
		//scrollWeekViewDown();
		
		//Set component listeners
		setMenuListeners();
		setDataPanelListeners();
		
		//Set data
		DataView.updateWeekList();
		DataView.updateMealList();
		
		//Set week
		DataView.setSelectedWeek();
		setTitle();
		

	}
	
	private void setMenuListeners(){
		//Settings
		MIsettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				csw.show();
			}});
		//Exit
		MIexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(confirm("Suljetaan","Suljetaanko?")) {
					CloseFrame();
				}
			}});
		//Print

		MIprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ScheduleBuilder.buildDocument(selectedWeek);
				ScheduleBuilder.printDocument();
				//showMessage("Tulostettava tekstidokumentti viety kansioon nimell� \"" + selectedWeek.getName()+  "-tulosta\"  ");
			}});

		
		//Add week
		MIaddWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cww.show();
			}});
		//Go to meal edit
		MIgoToMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mw.setVisible(true);
			}});
		//Help
		MIhelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ciw.guideInBrowser();
			}});
		//Info
		MIinfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showMessage(programAuthor);
			}});
	}
	

	
	private void setDataPanelListeners() {
		//LIST
		weekList.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						DataView.setSelectedWeek();
						setTitle();
					}});
		//LIST
		mealList.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						DataView.setSelectedMeal();
					}});
		//TABLE
		TBweekTable.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				   DataView.setTime(TBweekTable.columnAtPoint(e.getPoint()), TBweekTable.rowAtPoint(e.getPoint()));
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			
			public void mousePressed(MouseEvent e) {
				DataView.setTime(TBweekTable.columnAtPoint(e.getPoint()), TBweekTable.rowAtPoint(e.getPoint()));
			}
			public void mouseReleased(MouseEvent e) {
				DataView.setTime(TBweekTable.columnAtPoint(e.getPoint()), TBweekTable.rowAtPoint(e.getPoint()));
			}
		});
		//TABLE key listener
		TBweekTable.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent arg0) {
			}
			public void keyReleased(KeyEvent e) {
				if(TBweekTable.getSelectedColumn()>0 && TBweekTable.getSelectedRow()>=0)
					DataView.setTime(TBweekTable.getSelectedColumn(), TBweekTable.getSelectedRow());
			}
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		
				
		//BTN 
		BTnewWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cww.show();
				cww.newWeek();
			}});
		//BTN 
		BTdeleteWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataView.deleteWeek();
			}});
		//BTN 
		BTeditWeek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cww.show();
				cww.editWeek(selectedWeek);
			}});
		
		//BTN 
		BTcontrolMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mw.setVisible(true);
			}});
		//BTN 
		BTemptyMeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DataView.emptyCell();
			}});
		
	}
	
	
	//public Update weekview 
	public static void updateWeekView() {
		DataView.updateWeekList();
	};
	
	//Scroll week down
	public static void scrollWeekViewDown() {
		jsc.getVerticalScrollBar().setValue( jsc.getVerticalScrollBar().getMaximum());
	}
	
	//Change title
	private void setTitled(String ss) {
		this.setTitle(ss);
	}

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
	
	private void setTitle() {
		if(selectedWeek!=null) {
			setTitled(title + " - " +  selectedWeek.getName());
		}else {
			setTitled(title);
		}
	}
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}
}
