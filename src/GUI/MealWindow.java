package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUIlistener.ExitListener;
import GUIlistener.HelpListener;


public class MealWindow extends JFrame{
	
	//String
	private static String title = "Rakenna ateria";
	private static String tab1Title = "Ateria";
	private static String tab2Title = "Elintarvike";
	private static String groupTitle1 = "Uusi ateria";
	private static String groupTitle2 = "Elintarvikkeet";
	
	//Dimension
	private static int windowWidth = 600;
	private static int windowHeight = 320;

	
	//View
	
	//Tablayout
	JPanel mealPanel = new JPanel();
	JPanel foodPanel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane();
	
	//Meal
	JPanel mealGrid = new JPanel(new GridLayout(1,2));
	
	JList LmealIncridients = new JList();
	JList LfoodList1 = new JList();
	private static String[] testList = {"Kananmuna", "Sipsi", "Rahka", "Nakki", "Juustosipsi"};
	

	//New meal
	JTextField JTmealName = new JTextField();
	JLabel LselectedIncridient = new JLabel();
	JButton BremoveIncridient = new JButton();
	JTextField TFweight = new JTextField();
	JLabel LaddNewIncridient = new JLabel();
	JButton BaddNewIncridient = new JButton();
	JLabel LkcalsCount = new JLabel();

	
	JPanel inner;
	
	//Constructor
	public MealWindow() {
		super(title);
		
		//Set default close operation
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Build components
		buildView();
		
		//Set window size
		setSize(windowWidth,windowHeight);
		
		//Set components visible
		this.setVisible(true);

	}

	private void buildView() {
		inner = new JPanel(new GridLayout(1,1,20,10));
		buildTabs();
		this.getContentPane().add(inner);
	}

	private void buildTabs() {
		inner = new JPanel(new GridLayout(1,1,20,10));
		
		buildMealPanelLayout();
		buildFoodPanelLayout();
		
		tabbedPane.add(tab1Title, mealPanel);
		tabbedPane.add(tab2Title, foodPanel);
		inner.add(tabbedPane);
	}
	
	
	//Build meal panel layout--------------------------------------------------------------------------
	private void buildMealPanelLayout() {
		buildMealMealPamel();
		buildMealFoodPanel();
		mealPanel.add(mealGrid);
	}

	//MealMealPanel
	private void buildMealMealPamel() {
	
		Box mealBox = Box.createVerticalBox();
		mealBox.setBorder(BorderFactory.createTitledBorder(groupTitle1));
		
		//Name
		Box nameBox = Box.createVerticalBox();
		nameBox.setBorder(BorderFactory.createTitledBorder("Nimi"));
		JTmealName.setPreferredSize(new Dimension(200,20));
		nameBox.add(JTmealName);
		mealBox.add(nameBox);//Add to mealbox///////
		
		//Incridients
		Box incridientBox = Box.createVerticalBox();
		incridientBox.setBorder(BorderFactory.createTitledBorder("Sisältö"));
		
		//Add incridient
		//Add new incridient
		BaddNewIncridient.setText("Lisää");
		Box addNewInc = Box.createHorizontalBox();	
		LaddNewIncridient.setText("Juustosipsi (g/ml): ");
		addNewInc.add(LaddNewIncridient);
		addNewInc.add(TFweight);
		addNewInc.add(BaddNewIncridient);
		incridientBox.add(addNewInc);//Add to mealbox///////////////

		
		//Set incridient list
		Box incridientBox2 = Box.createVerticalBox();
		LmealIncridients.setListData(testList);
		LmealIncridients.setVisibleRowCount(3);
		LmealIncridients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		LmealIncridients.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						JOptionPane.showMessageDialog(getParent(), "asd " + arg0.getLastIndex());
					}
			});
		incridientBox2.add(new JScrollPane(LmealIncridients));
		incridientBox.add(incridientBox2);//Add to mealbox/////
		
		
		//Selected incridient
		Box selectedIncBox = Box.createVerticalBox();		
		LselectedIncridient.setText("Maitomanna 100g 100kcal ");
		selectedIncBox.add(LselectedIncridient);		
		incridientBox.add(selectedIncBox);//Add to mealbox///////////////
		
		//Remove button
		JPanel sRemovePanel = new JPanel(new BorderLayout());		
		BremoveIncridient.setText("Poista");
		sRemovePanel.add(BremoveIncridient, BorderLayout.EAST);
		incridientBox.add(sRemovePanel);//Add to mealbox///////////////
		
		//Kcals count
		JPanel kcalCount = new JPanel(new BorderLayout());	
		LkcalsCount.setText("Yht: 200 Kcal");
		LkcalsCount.setFont(LkcalsCount.getFont().deriveFont(14.0f));
		kcalCount.add(LkcalsCount, BorderLayout.WEST);
		
		mealBox.add(incridientBox);	
		mealBox.add(kcalCount);	
		mealGrid.add(mealBox);
	}

	//Mealfoodpanel
	private void buildMealFoodPanel() {
		Box mealFoodBox = Box.createVerticalBox();
		mealFoodBox.setBorder(BorderFactory.createTitledBorder(groupTitle2));
		
		
		LfoodList1.setListData(testList);
		LfoodList1.setVisibleRowCount(3);
		LfoodList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		LfoodList1.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						JOptionPane.showMessageDialog(getParent(), "asd " + arg0.getLastIndex());
					}
			});
		
		mealFoodBox.add(new JScrollPane(LfoodList1));
		
		mealGrid.add(mealFoodBox);
		
	}

	
	
	
	
	
	//Build food panel layout------------------------------------------------------------------
	private void buildFoodPanelLayout() {
		
		
		
	}
	




}
