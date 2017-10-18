package GUImeal;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DB.AdapterFood;
import DB.AdapterFood100g;
import DB.AdapterMeal;
import Model.Food;
import Model.Food100g;
import Utility.Utility;

public class MealWindow extends JFrame{
	
	//String
	protected static String title = "Hallitse aterioita ja elintarvikkeita";
	//mTab
	protected static String tab1Title = "Ateriat";
	protected static String tab2Title = "Elintarvikeet";
	protected static String groupTitle1 = "Uusi ateria";
	protected static String groupTitle2 = "Elintarvikkeet";
	protected static String nameLabel = "Nimi: ";
	protected static String incridientLabel = "Sisältö";
	//fTab
	protected static String newFpnael = "Uusi elintarvike";
	protected static String newFname = "Nimi: ";
	protected static String newFkcal = "Kcal: ";
	protected static String newFfoods = "Elintarvikkeet";
	
	//Dimension
	protected static int windowWidth = 500;
	protected static int windowHeight = 410;
	protected static int panelWidth1 = 200;
	protected static int foodListHeight = 12;
	
	//View Components----------------------------------------------------------------------------------
	protected static JPanel inner = new JPanel(new GridLayout(1,1,20,10));;
	protected static JPanel mealPanel = new JPanel();
	protected static JPanel foodPanel = new JPanel();
	protected static JTabbedPane tabbedPane = new JTabbedPane();
	protected static JPanel mealGrid = new JPanel(new GridLayout(1,2));
	protected static JPanel foodGrid = new JPanel(new GridLayout(1,2));
	
	//--        --       --       --    --       --       --    --       --       --
	
	//Meal components
	protected static JList LmealIncridients = new JList();
	protected static JList LfoodList1 = new JList();
	
	//New meal
	protected static JTextField JTmealName = new JTextField();
	protected static JLabel LselectedIncridient = new JLabel();
	protected static JButton BremoveIncridient = new JButton();
	protected static JTextField TFweight = new JTextField();
	protected static JLabel LaddNewIncridient = new JLabel();
	protected static JLabel LaddNewIncridientWeight = new JLabel();
	protected static JButton BaddNewIncridient = new JButton();
	protected static JLabel LkcalsCount = new JLabel();
	
	//Meal ready
	protected static JButton BmealReady = new JButton();
	protected static JButton BmealCancel = new JButton();
	
	//--        --       --       --    --       --       --    --       --       --
	
	//Food components
	protected static JTextField JTfoodName = new JTextField();
	protected static JTextField JTfoodKcal = new JTextField();
	protected static JButton BfoodEmpty = new JButton();
	protected static JButton BfoodAdd = new JButton();
	
	//Food list
	protected static JList LfoodList2 = new JList();
	protected static JButton BfoodRemove = new JButton();
	protected static JButton BfoodEdit = new JButton();
	
	//Food ready
	protected static JButton BfoodExit = new JButton();	
	
	
	//Contents--------------------------------------------------------------------------------------
	
	//Database
	protected static  AdapterFood100g af100= new AdapterFood100g();
	protected static  AdapterFood afood= new AdapterFood();
	protected static  AdapterMeal ameal= new AdapterMeal();
	
	//New meal
	protected static  Food selectedIncridient = null;
	protected static  Food100g selectedFood = null;
	protected static ArrayList<Food> mealIncridients = new ArrayList();
	
	

	//Construtor
	public MealWindow() {
		
		//Build window
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MealWindowBuilder.buildWindow(); //Builds window
		this.getContentPane().add(inner);
		setSize(windowWidth,windowHeight);
		this.setVisible(true);
		this.setResizable(false);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		//Component listeners
		setMealTabListeners();
		setFoodTabListeners();
		
		//Set data
		MealTab.updateFoodlist1();
		FoodTab.updateFoodlist2();
		MealTab.updateTotalKcal();
		
	}
	
	
	//Action Listeners START-----------------------------------------------------------------
	
	//Set FOODtab LISTENERs to components
	private void setFoodTabListeners() {
		//LIST f2
		LfoodList2.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						
					}});
		//BTN empty
		BfoodEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FoodTab.emptyFields();
			}});
		//BTN add
		BfoodAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FoodTab.addFood();
			}});
		//BTN remove
		BfoodRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}});
		//BTN edit
		BfoodEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}});

		//BTN cacel
		BfoodExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}});
	}
	
	//--        --       --       --    --       --       --    --       --       --
	
	//Set MEALtab LISTEERs to components
	private void setMealTabListeners() {
		//LIST f1
		LfoodList1.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						MealTab.setSelectedFood1();
					}});
		//LIST incridient
		LmealIncridients.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						MealTab.setSelectedIncridient();
					}});
		//BTN Add 
		BaddNewIncridient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MealTab.addIncridient();
			}});
		//BTN Remove 
		BremoveIncridient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MealTab.removeIncridient();
			}});
		//BTN Ready 
		BmealReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (MealTab.mealReady()) {
					CloseFrame();
				}
			}});
		//BTN Cancel 
		BmealCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}});
	}
	
	//Action Listeners END-----------------------------------------------------------------
	
	
	
	
	//Show dialog message
	public static void showMessage(String msg) {
		JOptionPane.showMessageDialog(inner, msg);
	}
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}

}
