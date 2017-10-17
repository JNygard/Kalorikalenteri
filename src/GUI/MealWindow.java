package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


public class MealWindow extends JFrame{
	
	//String
	private static String title = "Rakenna ateria";
	private static String tab1Title = "Ateria";
	private static String tab2Title = "Elintarvike";
	private static String groupTitle1 = "Uusi ateria";
	private static String groupTitle2 = "Valitse elintarvikkeet listasta";
	
	//Dimension
	private static int windowWidth = 600;
	private static int windowHeight = 450;
	private static int panelWidth1 = 230;
	
	//View//////////////////////////////////////////////////////////////////////////////
	JPanel inner;
	
	//Tablayout
	JPanel mealPanel = new JPanel();
	JPanel foodPanel = new JPanel();
	JTabbedPane tabbedPane = new JTabbedPane();
	
	//Meal/////////////////////////////////////
	JPanel mealGrid = new JPanel(new GridLayout(1,2));
	JList LmealIncridients = new JList();
	JList LfoodList1 = new JList();
	private static String[] testList = {"Kananmuna", "Sipsi", "Rahka", "Nakki", "Juustosipsi", "Peruna",
			"Maito", "Pasta", "Jauheliha", "Kana", "Salaatti", "Muussi", "Makkara"};
	//New meal
	JTextField JTmealName = new JTextField();
	JLabel LselectedIncridient = new JLabel();
	JButton BremoveIncridient = new JButton();
	JTextField TFweight = new JTextField();
	JLabel LaddNewIncridient = new JLabel();
	JButton BaddNewIncridient = new JButton();
	JLabel LkcalsCount = new JLabel();
	
	JButton BmealReady = new JButton();
	JButton BmealCancel = new JButton();
	
	//Food/////////////////////////////////////
	JPanel foodGrid = new JPanel(new GridLayout(1,2));
	JTextField JTfoodName = new JTextField();
	JTextField JTfoodKcal = new JTextField();
	JButton BfoodEmpty = new JButton();
	JButton BfoodAdd = new JButton();
	
	//List
	JList LfoodList2 = new JList();
	JButton BfoodRemove = new JButton();
	JButton BfoodEdit = new JButton();
	
	
	JButton BfoodReady = new JButton();
	JButton BfoodCancel = new JButton();
	
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

	//Build view
	private void buildView() {
		inner = new JPanel(new GridLayout(1,1,20,10));
		buildTabs();
		this.getContentPane().add(inner);
		setListeners();
	}

	//LISENERS START////////////////////////////////////////////////////////////////
	private void setListeners() {
		
		
		//Meal Listeners-------------------------------------
		
		//Meal ready
		BmealReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getParent(), "Valmis");
			}
		});
		//Cancel, exit
		BmealCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}
		});
		
		//FoodListeners---------------------------------------
		
		//Food ready
		BfoodReady.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(getParent(), "Valmis f");
			}
		});
		//Cancel, exit
		BfoodCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseFrame();
			}
		});
		
	}
	public void CloseFrame(){
	    super.dispose();
	}
	//LISENERS END////////////////////////////////////////////////////////////////
	
	
	
	//Build tabs
	private void buildTabs() {
		inner = new JPanel(new GridLayout(1,1,20,10));
		
		buildMealPanelLayout();
		buildFoodPanelLayout();
		
		tabbedPane.add(tab1Title, mealPanel);
		tabbedPane.add(tab2Title, foodPanel);
		inner.add(tabbedPane);
	}
	
	//Build food panel layout////////////////////////////////////////////////////////////////////////
	private void buildFoodPanelLayout() {
		buildnewFoodPanel();
		buildFoodListPanel();
		foodPanel.add(foodGrid);
		
		BfoodReady.setText("Valmis");
		BfoodCancel.setText("Peruuta");
		foodPanel.add(BfoodCancel, BorderLayout.NORTH);
		foodPanel.add(BfoodReady, BorderLayout.NORTH);
		
	}
	
	//Build new food panel
	private void buildnewFoodPanel() {
		Box foodBox = Box.createVerticalBox();
		foodBox.setBorder(BorderFactory.createTitledBorder("Uusi elintarvike"));
		
		//Name
		Box nameBox = Box.createHorizontalBox();
		nameBox.setMaximumSize(new Dimension(panelWidth1,20));
		nameBox.add(new JLabel("Nimi: "));
		JTfoodName.setPreferredSize(new Dimension(panelWidth1,20));
		nameBox.add(JTfoodName);
		foodBox.add(nameBox);//Add to mealbox///////
		
		
		//kcal
		Box kcalBox = Box.createHorizontalBox();
		kcalBox.setMaximumSize(new Dimension(panelWidth1,20));
		kcalBox.add(new JLabel("Kcal: "));
		JTfoodKcal.setPreferredSize(new Dimension(panelWidth1,20));
		kcalBox.add(JTfoodKcal);
		foodBox.add(kcalBox);//Add to mealbox///////
		
		
		
		//Buttons
		JPanel sFoodButtonPanel = new JPanel(new GridLayout(1,2));		
		//Cancel 
		BfoodEmpty.setText("Peru");
		sFoodButtonPanel.add(BfoodEmpty);
		//Add
		BfoodAdd.setText("Lisää");
		sFoodButtonPanel.add(BfoodAdd);	
		foodBox.add(sFoodButtonPanel, BorderLayout.NORTH); //Add ///////////////
		sFoodButtonPanel.setMaximumSize(new Dimension(panelWidth1,25));
		
		
		
				
		
		
		
		foodGrid.add(foodBox);
	}
		
	//Build foodlist panel
	private void buildFoodListPanel() {
		Box foodList = Box.createVerticalBox();
		foodList.setBorder(BorderFactory.createTitledBorder("Elintarvikkeet"));
		
			
		//List
		LfoodList2.setListData(testList);
		LfoodList2.setVisibleRowCount(10);
		LfoodList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		LfoodList2.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						JOptionPane.showMessageDialog(getParent(), "asd " + arg0.getLastIndex());
					}
			});
		foodList.add(new JScrollPane(LfoodList2));//ADD///////////////
		
		//Remove and edit button
		JPanel sRemoveEditPanel = new JPanel(new GridLayout(1,2));		
		//Remove 
		BfoodEdit.setText("Muokkaa");
		sRemoveEditPanel.add(BfoodEdit);
		//Edit
		BfoodRemove.setText("Poista");
		sRemoveEditPanel.add(BfoodRemove);	
		foodList.add(sRemoveEditPanel); //Add ///////////////
		
		
		foodGrid.add(foodList);
	}

	

	//Build meal panel layout////////////////////////////////////////////////////////////////////////
	private void buildMealPanelLayout() {
		buildMealMealPamel();
		buildMealFoodPanel();
		mealPanel.add(mealGrid);
		
		BmealReady.setText("Valmis");
		BmealCancel.setText("Peruuta");
		mealPanel.add(BmealCancel, BorderLayout.NORTH);
		mealPanel.add(BmealReady, BorderLayout.NORTH);
		
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
		LmealIncridients.setVisibleRowCount(8);
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
		kcalCount.add(LkcalsCount, BorderLayout.WEST);//Add to mealbox///////////////
		
		
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

	


}
