package GUImeal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import DB.AdapterFood;
import DB.AdapterFood100g;
import DB.AdapterMeal;

public class MealWindow extends JFrame{
	
	//Database
	static AdapterFood100g af100= new AdapterFood100g();
	static AdapterFood afood= new AdapterFood();
	static AdapterMeal ameal= new AdapterMeal();
	
	//String
	protected static String title = "Rakenna ateria";
	protected static String tab1Title = "Ateria";
	protected static String tab2Title = "Elintarvike";
	protected static String groupTitle1 = "Uusi ateria";
	protected static String groupTitle2 = "Valitse elintarvikkeet listasta";
	
	//Dimension
	protected static int windowWidth = 600;
	protected static int windowHeight = 450;
	protected static int panelWidth1 = 230;
	
	
	
	//Components
	protected static JPanel inner = new JPanel(new GridLayout(1,1,20,10));;
	protected static JPanel mealPanel = new JPanel();
	protected static JPanel foodPanel = new JPanel();
	protected static JTabbedPane tabbedPane = new JTabbedPane();
	protected static JPanel mealGrid = new JPanel(new GridLayout(1,2));
	protected static JPanel foodGrid = new JPanel(new GridLayout(1,2));
	
	//Meal components
	protected static JList LmealIncridients = new JList();
	protected static JList LfoodList1 = new JList();

	//New meal
	protected static JTextField JTmealName = new JTextField();
	protected static JLabel LselectedIncridient = new JLabel();
	protected static JButton BremoveIncridient = new JButton();
	protected static JTextField TFweight = new JTextField();
	protected static JLabel LaddNewIncridient = new JLabel();
	protected static JButton BaddNewIncridient = new JButton();
	protected static JLabel LkcalsCount = new JLabel();
	
	protected static JButton BmealReady = new JButton();
	protected static JButton BmealCancel = new JButton();
	
	//Food/////////////////////////////////////
	
	protected static JTextField JTfoodName = new JTextField();
	protected static JTextField JTfoodKcal = new JTextField();
	protected static JButton BfoodEmpty = new JButton();
	protected static JButton BfoodAdd = new JButton();
	
	//List
	protected static JList LfoodList2 = new JList();
	protected static JButton BfoodRemove = new JButton();
	protected static JButton BfoodEdit = new JButton();
	
	protected static JButton BfoodReady = new JButton();
	protected static JButton BfoodCancel = new JButton();	
	
	

	//Construtor
	public MealWindow() {
		
		//Build window
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MealWindowBuilder.buildWindow(); //Builds window
		this.getContentPane().add(inner);
		setSize(windowWidth,windowHeight);
		this.setVisible(true);
		setMealTabListeners();
		setFoodTabListeners();
		
		//Set data
		updateFoodlist1();
		updateFoodlist2();
	}
	
	//Set mealtab listeners to components
	private void setMealTabListeners() {
		//BTN Add 
		BaddNewIncridient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}});
		//BTN Remove 
		BremoveIncridient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}});
		//BTN Ready 
		BmealReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}});
		//BTN Cancel 
		BmealCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}});
		
	}
	
	//Set foodtab listeners to components
	private void setFoodTabListeners() {
		
		
	}
	
	
	//Update foodlist tab1
	private void updateFoodlist1() {
		LfoodList1.setListData(af100.getAllString().toArray());
	}
	//Update foodlist tab2
	private void updateFoodlist2() {
		LfoodList2.setListData(af100.getAllString().toArray());
	}
	
	
	
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}

}
