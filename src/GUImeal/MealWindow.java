package GUImeal;

import java.awt.GridLayout;
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
	protected static String title = "Rakenna ateria";
	protected static String tab1Title = "Ateria";
	protected static String tab2Title = "Elintarvike";
	protected static String groupTitle1 = "Uusi ateria";
	protected static String groupTitle2 = "Valitse elintarvikkeet listasta";
	
	//Dimension
	protected static int windowWidth = 500;
	protected static int windowHeight = 450;
	protected static int panelWidth1 = 230;
	
	//View Components----------------------------------------------------------------------------------
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
	protected static JLabel LaddNewIncridientWeight = new JLabel();
	protected static JButton BaddNewIncridient = new JButton();
	protected static JLabel LkcalsCount = new JLabel();
	
	//Meal ready
	protected static JButton BmealReady = new JButton();
	protected static JButton BmealCancel = new JButton();
	
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
	protected static JButton BfoodReady = new JButton();
	protected static JButton BfoodCancel = new JButton();	
	
	
	//Contents--------------------------------------------------------------------------------------
	
	//Database
	static AdapterFood100g af100= new AdapterFood100g();
	static AdapterFood afood= new AdapterFood();
	static AdapterMeal ameal= new AdapterMeal();
	
	//New meal
	private Food selectedIncridient = null;
	private Food100g selectedFood = null;
	private ArrayList<Food> mealIncridients = new ArrayList();
	
	

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
	
	//Set mealtab LISTEERs to components
	private void setMealTabListeners() {
		//LIST f1
		LfoodList1.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						setSelectedFood1();
					}});
		
		//LIST incridient
		LmealIncridients.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent arg0) {
						setSelectedIncridient();
					}});
		//BTN Add 
		BaddNewIncridient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addIncridient();
			}});
		//BTN Remove 
		BremoveIncridient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				removeIncridient();
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
	
	
	//Add incridient
	private void addIncridient() {
		if(selectedFood==null) {
			JOptionPane.showMessageDialog(getParent(), "Ei valittua elintarviketta");
			return;
		}
		int amount = 0;
		try { amount = Integer.parseInt(TFweight.getText());
		} catch(Exception e) {
			JOptionPane.showMessageDialog(getParent(), "Virheellinen m‰‰r‰.");return;}
		this.mealIncridients.add(new Food(0, selectedFood, amount, 0));
		TFweight.setText("");
		updateIncridientList();
	}
	
	//Remove incridient
	private void removeIncridient() {
		this.mealIncridients.remove(0);
		updateIncridientList();
	}
	
	//Set selected food1
	private void setSelectedFood1() {
		this.selectedFood = this.af100.get(LfoodList1.getSelectedValue().toString());
		//JOptionPane.showMessageDialog(getParent(), selectedFood.getName() );
		LaddNewIncridient.setText(this.selectedFood.getName() + " | " + this.selectedFood.getKcal() + " kcal/100g");
	}
	
	//Set selected incridient
	private void setSelectedIncridient() {
		this.selectedIncridient = this.mealIncridients.get(LmealIncridients.getSelectedIndex());
		
		LselectedIncridient.setText(
				selectedIncridient.getFood100g().getName() + " " +
				Utility.calculateFoodCalories(selectedIncridient.getFood100g().getKcal(), selectedIncridient.getGrams()) +
				"Kcal"
				);	
	}
	
	//Update foodlist tab1
	private void updateFoodlist1() {
		LfoodList1.setListData(af100.getAllString(0).toArray());
	}
	//Update incridient list
	private void updateIncridientList() {
		if(this.mealIncridients!=null) {
			ArrayList<String> sa = Utility.toFood100toStringArray(this.mealIncridients);
			LmealIncridients.setListData(sa.toArray());
		}
	}
	
	
	//Update foodlist tab2
	private void updateFoodlist2() {
		LfoodList2.setListData(af100.getAllString(0).toArray());
	}
	
	
	
	
	//Close window
	public void CloseFrame(){
	    super.dispose();
	}

}
