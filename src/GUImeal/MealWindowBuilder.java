package GUImeal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import Utility.Utility;

public class MealWindowBuilder {


	//Build Meal Window
	protected static void buildWindow() {
		buildTabs();
	}
	

	
	//Build tabs
	private static void buildTabs() {
		
		buildMealPanelLayout();
		buildFoodPanelLayout();
		
		MealWindow.tabbedPane.add(MealWindow.tab1Title,MealWindow.mealPanel);
		MealWindow.tabbedPane.add(MealWindow.tab2Title, MealWindow.foodPanel);
		MealWindow.inner.add(MealWindow.tabbedPane);
	}
	
	//Build food panel layout////////////////////////////////////////////////////////////////////////
	private static void buildFoodPanelLayout() {
		buildnewFoodPanel();
		buildFoodListPanel();
		
		MealWindow.foodPanel.add(MealWindow.foodGrid);
		
		MealWindow.BfoodExit.setText("Poistu");
		MealWindow.foodPanel.add(MealWindow.BfoodExit, BorderLayout.NORTH);
		
	}
	

	
	//Build new food panel
	private static void buildnewFoodPanel() {
		Box foodBox = Box.createVerticalBox();
		foodBox.setBorder(BorderFactory.createTitledBorder(MealWindow.newFpnael));
		
		//Name
		Box nameBox = Box.createHorizontalBox();
		nameBox.setMaximumSize(new Dimension(MealWindow.panelWidth1,MealWindow.inputHeight1));
		nameBox.add(new JLabel(MealWindow.newFname));
		MealWindow.JTfoodName.setPreferredSize(new Dimension(MealWindow.panelWidth1,MealWindow.inputHeight1));
		nameBox.add(MealWindow.JTfoodName);
		foodBox.add(nameBox);//Add to mealbox///////
		
		
		//kcal
		Box kcalBox = Box.createHorizontalBox();
		kcalBox.setMaximumSize(new Dimension(MealWindow.panelWidth1,MealWindow.inputHeight1));
		kcalBox.add(new JLabel(MealWindow.newFkcal));
		MealWindow.JTfoodKcal.setPreferredSize(new Dimension(MealWindow.panelWidth1,MealWindow.inputHeight1));
		kcalBox.add(MealWindow.JTfoodKcal);
		foodBox.add(kcalBox);//Add to mealbox///////
		
		
		
		//Buttons
		JPanel sFoodButtonPanel = new JPanel(new GridLayout(1,2));		
		//Cancel 
		MealWindow.BfoodEmpty.setText("Tyhjenn‰");
		sFoodButtonPanel.add(MealWindow.BfoodEmpty);
		//Add
		MealWindow.BfoodAdd.setText("Lis‰‰");
		sFoodButtonPanel.add(MealWindow.BfoodAdd);	
		foodBox.add(sFoodButtonPanel, BorderLayout.NORTH); //Add ///////////////
		sFoodButtonPanel.setMaximumSize(new Dimension(MealWindow.panelWidth1,25));
		
		
	
		MealWindow.foodGrid.add(foodBox);
	}
		
	//Build foodlist panel
	private static void buildFoodListPanel() {
		Box foodList = Box.createVerticalBox();
		foodList.setBorder(BorderFactory.createTitledBorder(MealWindow.newFfoods));
		
			
		//List
		MealWindow.LfoodList2.setVisibleRowCount(MealWindow.foodListHeight);
		MealWindow.LfoodList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		foodList.add(new JScrollPane(MealWindow.LfoodList2));//ADD///////////////
		
		//Remove and edit button
		JPanel sRemoveEditPanel = new JPanel(new GridLayout(1,2));		
		//Remove 
		MealWindow.BfoodEdit.setText("Muokkaa");
		sRemoveEditPanel.add(MealWindow.BfoodEdit);
		//Edit
		MealWindow.BfoodRemove.setText("Poista");
		sRemoveEditPanel.add(MealWindow.BfoodRemove);	
		foodList.add(sRemoveEditPanel); //Add ///////////////
		
		
		MealWindow.foodGrid.add(foodList);
	}

	

	//Build meal panel layout////////////////////////////////////////////////////////////////////////
	private static void buildMealPanelLayout() {
		buildMealMealPamel();
		buildMealFoodPanel();
		
		
		MealWindow.mealPanel.add(MealWindow.meallistGrid);
		MealWindow.mealPanel.add(MealWindow.mealGrid);
		MealWindow.mealGrid.setVisible(false);
		
		MealWindow.BmealReady.setText("Tallenna");
		MealWindow.BmealCancel.setText("Poistu");
		MealWindow.mealPanel.add(MealWindow.BmealCancel, BorderLayout.NORTH);
		MealWindow.mealPanel.add(MealWindow.BmealReady, BorderLayout.NORTH);
		
	}

	//MealMealPanel
	private static void buildMealMealPamel() {
	
		Box mealBox = Box.createVerticalBox();
		mealBox.setBorder(BorderFactory.createTitledBorder(MealWindow.groupTitle1));
		
		Box mealBox2 = Box.createVerticalBox();
		mealBox2.setBorder(BorderFactory.createTitledBorder(MealWindow.groupTitle3));

		
		//Meallist
		Box mealListBox = Box.createHorizontalBox();
		Box emptybox = Box.createHorizontalBox();
		MealWindow.JCmealList = new JComboBox(Utility.mealToStringArray(MealWindow.ameal.getAll()).toArray());
		mealListBox.add(MealWindow.JCmealList);
		MealWindow.JCmealList.setPreferredSize(new Dimension(MealWindow.panelWidth1+28, MealWindow.inputHeight1));
		mealBox2.add(mealListBox);
		
		
		JPanel REDpanel = new JPanel(new GridLayout(1,3));	
		REDpanel.add(MealWindow.BmealDelete);
		//REDpanel.add(MealWindow.BmealEdit);
		REDpanel.add(MealWindow.BmealNew);
		mealBox2.add(REDpanel);
		
		MealWindow.meallistGrid.add(mealBox2);
		MealWindow.meallistGrid.add(emptybox);
		
		//Name
		Box nameBox = Box.createHorizontalBox();
		MealWindow.JTmealName.setPreferredSize(new Dimension(MealWindow.panelWidth1,MealWindow.inputHeight1));
		nameBox.add(new JLabel(MealWindow.nameLabel));
		nameBox.add(MealWindow.JTmealName);
		mealBox.add(nameBox);//Add to mealbox///////
		
		//Incridients
		Box incridientBox = Box.createVerticalBox();
		incridientBox.setBorder(BorderFactory.createTitledBorder(MealWindow.incridientLabel));
		
		//Add incridient
		Box selectedFoodBox = Box.createHorizontalBox();
		MealWindow.LaddNewIncridient.setText("");
		selectedFoodBox.add(MealWindow.LaddNewIncridient);
		incridientBox.add(selectedFoodBox);
		
		//Add new incridient
		MealWindow.BaddNewIncridient.setEnabled(false);
		MealWindow.BaddNewIncridient.setText("Lis‰‰");
		Box addNewInc = Box.createHorizontalBox();	
		MealWindow.LaddNewIncridientWeight.setText("M‰‰r‰ (g/ml): ");
		addNewInc.add(MealWindow.LaddNewIncridientWeight);
		addNewInc.add(MealWindow.TFweight);
		addNewInc.add(MealWindow.BaddNewIncridient);
		incridientBox.add(addNewInc);//Add to mealbox///////////////

		
		//Set incridient list
		Box incridientBox2 = Box.createVerticalBox();
		String[] s =  {" "};
		MealWindow.LmealIncridients.setListData(s);
		MealWindow.LmealIncridients.setVisibleRowCount(8);
		MealWindow.LmealIncridients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*
		LmealIncridients.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						JOptionPane.showMessageDialog(getParent(), "asd " + arg0.getLastIndex());
					}
			});
			*/
		incridientBox2.add(new JScrollPane(MealWindow.LmealIncridients));
		incridientBox.add(incridientBox2);//Add to mealbox/////
		
		
		//Selected incridient
		Box selectedIncBox = Box.createHorizontalBox();		
		MealWindow.LselectedIncridient.setText("");
		selectedIncBox.add(MealWindow.LselectedIncridient);		
		incridientBox.add(selectedIncBox);//Add to mealbox///////////////
		
		//Remove button
		JPanel sRemovePanel = new JPanel(new BorderLayout());
		MealWindow.BremoveIncridient.setEnabled(false);
		MealWindow.BremoveIncridient.setText("Poista");
		sRemovePanel.add(MealWindow.BremoveIncridient, BorderLayout.EAST);
		incridientBox.add(sRemovePanel);//Add to mealbox///////////////
		
		//Kcals count
		JPanel kcalCount = new JPanel(new BorderLayout());	
		MealWindow.LkcalsCount.setText("Yht: 200 Kcal");
		MealWindow.LkcalsCount.setFont(MealWindow.LkcalsCount.getFont().deriveFont(14.0f));
		kcalCount.add(MealWindow.LkcalsCount, BorderLayout.WEST);//Add to mealbox///////////////
		
		
		mealBox.add(incridientBox);	
		mealBox.add(kcalCount);	
		MealWindow.mealGrid.add(mealBox);
	}

	//Mealfoodpanel
	private static void buildMealFoodPanel() {
		Box mealFoodBox = Box.createVerticalBox();
		mealFoodBox.setBorder(BorderFactory.createTitledBorder(MealWindow.groupTitle2));
		
		MealWindow.LfoodList1.setVisibleRowCount(MealWindow.foodListHeight);
		MealWindow.LfoodList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*
		MealWindow.LfoodList1.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						JOptionPane.showMessageDialog(getParent(), "asd " + arg0.getLastIndex());
					}
			});
			*/
		
		mealFoodBox.add(new JScrollPane(MealWindow.LfoodList1));
		MealWindow.mealGrid.add(mealFoodBox);
	}

	


}
