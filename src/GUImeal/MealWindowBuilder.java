package GUImeal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
		
		MealWindow.BfoodReady.setText("Valmis");
		MealWindow.BfoodCancel.setText("Peruuta");
		MealWindow.foodPanel.add(MealWindow.BfoodCancel, BorderLayout.NORTH);
		MealWindow.foodPanel.add(MealWindow.BfoodReady, BorderLayout.NORTH);
		
	}
	
	//Build new food panel
	private static void buildnewFoodPanel() {
		Box foodBox = Box.createVerticalBox();
		foodBox.setBorder(BorderFactory.createTitledBorder("Uusi elintarvike"));
		
		//Name
		Box nameBox = Box.createHorizontalBox();
		nameBox.setMaximumSize(new Dimension(MealWindow.panelWidth1,20));
		nameBox.add(new JLabel("Nimi: "));
		MealWindow.JTfoodName.setPreferredSize(new Dimension(MealWindow.panelWidth1,20));
		nameBox.add(MealWindow.JTfoodName);
		foodBox.add(nameBox);//Add to mealbox///////
		
		
		//kcal
		Box kcalBox = Box.createHorizontalBox();
		kcalBox.setMaximumSize(new Dimension(MealWindow.panelWidth1,20));
		kcalBox.add(new JLabel("Kcal: "));
		MealWindow.JTfoodKcal.setPreferredSize(new Dimension(MealWindow.panelWidth1,20));
		kcalBox.add(MealWindow.JTfoodKcal);
		foodBox.add(kcalBox);//Add to mealbox///////
		
		
		
		//Buttons
		JPanel sFoodButtonPanel = new JPanel(new GridLayout(1,2));		
		//Cancel 
		MealWindow.BfoodEmpty.setText("Peru");
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
		foodList.setBorder(BorderFactory.createTitledBorder("Elintarvikkeet"));
		
			
		//List
		MealWindow.LfoodList2.setVisibleRowCount(10);
		MealWindow.LfoodList2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		/*
		LfoodList2.addListSelectionListener(
				new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent arg0) {
						JOptionPane.showMessageDialog(getParent(), "asd " + arg0.getLastIndex());
					}
			});
			*/
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
		
		
		MealWindow.mealPanel.add(MealWindow.mealGrid);
		
		MealWindow.BmealReady.setText("Valmis");
		MealWindow.BmealCancel.setText("Peruuta");
		MealWindow.mealPanel.add(MealWindow.BmealCancel, BorderLayout.NORTH);
		MealWindow.mealPanel.add(MealWindow.BmealReady, BorderLayout.NORTH);
		
	}

	//MealMealPanel
	private static void buildMealMealPamel() {
	
		Box mealBox = Box.createVerticalBox();
		mealBox.setBorder(BorderFactory.createTitledBorder(MealWindow.groupTitle1));
		
		//Name
		Box nameBox = Box.createVerticalBox();
		nameBox.setBorder(BorderFactory.createTitledBorder("Nimi"));
		MealWindow.JTmealName.setPreferredSize(new Dimension(200,20));
		nameBox.add(MealWindow.JTmealName);
		mealBox.add(nameBox);//Add to mealbox///////
		
		//Incridients
		Box incridientBox = Box.createVerticalBox();
		incridientBox.setBorder(BorderFactory.createTitledBorder("Sis‰ltˆ"));
		
		//Add incridient
		Box selectedFoodBox = Box.createHorizontalBox();
		MealWindow.LaddNewIncridient.setText("");
		selectedFoodBox.add(MealWindow.LaddNewIncridient);
		incridientBox.add(selectedFoodBox);
		
		//Add new incridient
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
		
		MealWindow.LfoodList1.setVisibleRowCount(3);
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
